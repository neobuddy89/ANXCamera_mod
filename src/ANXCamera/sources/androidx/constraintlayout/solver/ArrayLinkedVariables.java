package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    private static final int NONE = -1;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    int currentSize = 0;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private final Cache mCache;
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    /* access modifiers changed from: package-private */
    public final void add(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 != 0.0f) {
            if (this.mHead == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f2;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[this.mHead] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (!this.mDidFillOnce) {
                    int i = this.mLast + 1;
                    this.mLast = i;
                    int[] iArr = this.mArrayIndices;
                    if (i >= iArr.length) {
                        this.mDidFillOnce = true;
                        this.mLast = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i2 = this.mHead;
            int i3 = -1;
            int i4 = 0;
            while (i2 != -1 && i4 < this.currentSize) {
                if (this.mArrayIndices[i2] == solverVariable.id) {
                    float[] fArr = this.mArrayValues;
                    fArr[i2] = fArr[i2] + f2;
                    if (fArr[i2] == 0.0f) {
                        if (i2 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i2];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i3] = iArr2[i2];
                        }
                        if (z) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i2;
                        }
                        solverVariable.usageInRowCount--;
                        this.currentSize--;
                        return;
                    }
                    return;
                }
                if (this.mArrayIndices[i2] < solverVariable.id) {
                    i3 = i2;
                }
                i2 = this.mArrayNextIndices[i2];
                i4++;
            }
            int i5 = this.mLast;
            int i6 = i5 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                i6 = iArr3[i5] == -1 ? this.mLast : iArr3.length;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i6 >= iArr4.length && this.currentSize < iArr4.length) {
                int i7 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i7 >= iArr5.length) {
                        break;
                    } else if (iArr5[i7] == -1) {
                        i6 = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i6 >= iArr6.length) {
                i6 = iArr6.length;
                int i8 = this.ROW_SIZE * 2;
                this.ROW_SIZE = i8;
                this.mDidFillOnce = false;
                this.mLast = i6 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i8);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i6] = solverVariable.id;
            this.mArrayValues[i6] = f2;
            if (i3 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[i6] = iArr7[i3];
                iArr7[i3] = i6;
            } else {
                this.mArrayNextIndices[i6] = this.mHead;
                this.mHead = i6;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i9 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i9 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SolverVariable chooseSubject(LinearSystem linearSystem) {
        LinearSystem linearSystem2 = linearSystem;
        SolverVariable solverVariable = null;
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            float f4 = this.mArrayValues[i];
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            if (f4 < 0.0f) {
                if (f4 > (-0.001f)) {
                    this.mArrayValues[i] = 0.0f;
                    f4 = 0.0f;
                    solverVariable3.removeFromRow(this.mRow);
                }
            } else if (f4 < 0.001f) {
                this.mArrayValues[i] = 0.0f;
                f4 = 0.0f;
                solverVariable3.removeFromRow(this.mRow);
            }
            if (f4 != 0.0f) {
                if (solverVariable3.mType == SolverVariable.Type.UNRESTRICTED) {
                    if (solverVariable2 == null) {
                        solverVariable2 = solverVariable3;
                        f2 = f4;
                        z = isNew(solverVariable3, linearSystem2);
                    } else if (f2 > f4) {
                        solverVariable2 = solverVariable3;
                        f2 = f4;
                        z = isNew(solverVariable3, linearSystem2);
                    } else if (!z && isNew(solverVariable3, linearSystem2)) {
                        solverVariable2 = solverVariable3;
                        f2 = f4;
                        z = true;
                    }
                } else if (solverVariable2 == null && f4 < 0.0f) {
                    if (solverVariable == null) {
                        solverVariable = solverVariable3;
                        f3 = f4;
                        z2 = isNew(solverVariable3, linearSystem2);
                    } else if (f3 > f4) {
                        solverVariable = solverVariable3;
                        f3 = f4;
                        z2 = isNew(solverVariable3, linearSystem2);
                    } else if (!z2 && isNew(solverVariable3, linearSystem2)) {
                        solverVariable = solverVariable3;
                        f3 = f4;
                        z2 = true;
                    }
                }
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return solverVariable2 != null ? solverVariable2 : solverVariable;
    }

    public final void clear() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean containsKey(SolverVariable solverVariable) {
        if (this.mHead == -1) {
            return false;
        }
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return true;
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return false;
    }

    public void display() {
        int i = this.currentSize;
        System.out.print("{ ");
        for (int i2 = 0; i2 < i; i2++) {
            SolverVariable variable = getVariable(i2);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i2) + " ");
            }
        }
        System.out.println(" }");
    }

    /* access modifiers changed from: package-private */
    public void divideByAmount(float f2) {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i] = fArr[i] / f2;
            i = this.mArrayNextIndices[i];
            i2++;
        }
    }

    public final float get(SolverVariable solverVariable) {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return this.mArrayValues[i];
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.candidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i = this.mHead;
        int i2 = 0;
        SolverVariable solverVariable2 = null;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return solverVariable2;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getPivotCandidate(boolean[] zArr, SolverVariable solverVariable) {
        int i = this.mHead;
        int i2 = 0;
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if ((zArr == null || !zArr[solverVariable3.id]) && solverVariable3 != solverVariable && (solverVariable3.mType == SolverVariable.Type.SLACK || solverVariable3.mType == SolverVariable.Type.ERROR)) {
                    float f3 = this.mArrayValues[i];
                    if (f3 < f2) {
                        f2 = f3;
                        solverVariable2 = solverVariable3;
                    }
                }
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return solverVariable2;
    }

    /* access modifiers changed from: package-private */
    public final SolverVariable getVariable(int i) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (i3 == i) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float getVariableValue(int i) {
        int i2 = this.mHead;
        int i3 = 0;
        while (i2 != -1 && i3 < this.currentSize) {
            if (i3 == i) {
                return this.mArrayValues[i2];
            }
            i2 = this.mArrayNextIndices[i2];
            i3++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAtLeastOnePositiveVariable() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayValues[i] > 0.0f) {
                return true;
            }
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void invert() {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i] = fArr[i] * -1.0f;
            i = this.mArrayNextIndices[i];
            i2++;
        }
    }

    public final void put(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            remove(solverVariable, true);
        } else if (this.mHead == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f2;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[this.mHead] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int i = this.mLast + 1;
                this.mLast = i;
                int[] iArr = this.mArrayIndices;
                if (i >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                }
            }
        } else {
            int i2 = this.mHead;
            int i3 = -1;
            int i4 = 0;
            while (i2 != -1 && i4 < this.currentSize) {
                if (this.mArrayIndices[i2] == solverVariable.id) {
                    this.mArrayValues[i2] = f2;
                    return;
                }
                if (this.mArrayIndices[i2] < solverVariable.id) {
                    i3 = i2;
                }
                i2 = this.mArrayNextIndices[i2];
                i4++;
            }
            int i5 = this.mLast;
            int i6 = i5 + 1;
            if (this.mDidFillOnce) {
                int[] iArr2 = this.mArrayIndices;
                i6 = iArr2[i5] == -1 ? this.mLast : iArr2.length;
            }
            int[] iArr3 = this.mArrayIndices;
            if (i6 >= iArr3.length && this.currentSize < iArr3.length) {
                int i7 = 0;
                while (true) {
                    int[] iArr4 = this.mArrayIndices;
                    if (i7 >= iArr4.length) {
                        break;
                    } else if (iArr4[i7] == -1) {
                        i6 = i7;
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            int[] iArr5 = this.mArrayIndices;
            if (i6 >= iArr5.length) {
                i6 = iArr5.length;
                int i8 = this.ROW_SIZE * 2;
                this.ROW_SIZE = i8;
                this.mDidFillOnce = false;
                this.mLast = i6 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i8);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i6] = solverVariable.id;
            this.mArrayValues[i6] = f2;
            if (i3 != -1) {
                int[] iArr6 = this.mArrayNextIndices;
                iArr6[i6] = iArr6[i3];
                iArr6[i3] = i6;
            } else {
                this.mArrayNextIndices[i6] = this.mHead;
                this.mHead = i6;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            if (this.currentSize >= this.mArrayIndices.length) {
                this.mDidFillOnce = true;
            }
            int i9 = this.mLast;
            int[] iArr7 = this.mArrayIndices;
            if (i9 >= iArr7.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr7.length - 1;
            }
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        if (this.mHead == -1) {
            return 0.0f;
        }
        int i = this.mHead;
        int i2 = -1;
        int i3 = 0;
        while (i != -1 && i3 < this.currentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                if (i == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i2] = iArr[i];
                }
                if (z) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i;
                }
                return this.mArrayValues[i];
            }
            i2 = i;
            i = this.mArrayNextIndices[i];
            i3++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public int sizeInBytes() {
        return 0 + (this.mArrayIndices.length * 4 * 3) + 36;
    }

    public String toString() {
        String str = "";
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            String str2 = str + " -> ";
            String str3 = str2 + this.mArrayValues[i] + " : ";
            str = str3 + this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            i = this.mArrayNextIndices[i];
            i2++;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void updateFromRow(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z) {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            if (this.mArrayIndices[i] == arrayRow2.variable.id) {
                float f2 = this.mArrayValues[i];
                remove(arrayRow2.variable, z);
                ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                int i3 = arrayLinkedVariables.mHead;
                int i4 = 0;
                while (i3 != -1 && i4 < arrayLinkedVariables.currentSize) {
                    add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i3]], arrayLinkedVariables.mArrayValues[i3] * f2, z);
                    i3 = arrayLinkedVariables.mArrayNextIndices[i3];
                    i4++;
                }
                arrayRow.constantValue += arrayRow2.constantValue * f2;
                if (z) {
                    arrayRow2.variable.removeFromRow(arrayRow);
                }
                i = this.mHead;
                i2 = 0;
            } else {
                i = this.mArrayNextIndices[i];
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateFromSystem(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        int i = this.mHead;
        int i2 = 0;
        while (i != -1 && i2 < this.currentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            if (solverVariable.definitionId != -1) {
                float f2 = this.mArrayValues[i];
                remove(solverVariable, true);
                ArrayRow arrayRow2 = arrayRowArr[solverVariable.definitionId];
                if (!arrayRow2.isSimpleDefinition) {
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                    int i3 = arrayLinkedVariables.mHead;
                    int i4 = 0;
                    while (i3 != -1 && i4 < arrayLinkedVariables.currentSize) {
                        add(this.mCache.mIndexedVariables[arrayLinkedVariables.mArrayIndices[i3]], arrayLinkedVariables.mArrayValues[i3] * f2, true);
                        i3 = arrayLinkedVariables.mArrayNextIndices[i3];
                        i4++;
                    }
                }
                arrayRow.constantValue += arrayRow2.constantValue * f2;
                arrayRow2.variable.removeFromRow(arrayRow);
                i = this.mHead;
                i2 = 0;
            } else {
                i = this.mArrayNextIndices[i];
                i2++;
            }
        }
    }
}
