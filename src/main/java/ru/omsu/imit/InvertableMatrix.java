package ru.omsu.imit;

public class InvertableMatrix extends Matrix implements IInvertableMatrix {

    public InvertableMatrix(){
        super();
    }

    public InvertableMatrix(int size, double...args){
        super(size,args);
    }

    public InvertableMatrix(InvertableMatrix puper){
        super(puper);
    }
    public InvertableMatrix invert(){
        InvertableMatrix result;
        double divCoef = 0;
        double[] orig = this.array.clone(), res = new double[size*size];
        for(int i = 0; i < size; i++){
            array[i*size + i] = 1;
        }

        for(int step = 0; step < size-1; step++){
            for(int row = step+1; row < size; row++){
                if(orig[step*size+step]!=0){
                    divCoef = orig[row*size+step]/orig[step*size+step];
                }else{
                    for(int i = 0;i < size; i++){
                        double buf = orig[row*size+i], buf1 = res[row*size+i];
                        orig[row*size+i] = - orig[step*size+i];
                        orig[step*size+i] = buf;
                        res[row*size+i] = - res[step*size+i];
                        res[step*size+i] = buf1;
                    }
                    divCoef = orig[row*size+step]/orig[step*size+step];
                }
                for(int col = 0; col < size; col++){
                    orig[row*size+col]-=divCoef*orig[step*size+col];
                    res[row*size+col]-=divCoef*res[step*size+col];
                }
            }
        }
        for(int step = size-1; step > 0; step--){
            for(int row = size-1; row>0;row--){
                divCoef = orig[row*size+step]/orig[step*size+step];
                for(int col = step; col > 0; col--){
                    orig[row*size+col]-=divCoef*orig[step*size+col];
                    res[row*size+col]-=divCoef*res[step*size+col];
                }
            }
        }
        result = new InvertableMatrix(res.length,res);
        return result;
    }
}
// a a1 a2
// 0 b  b1
// 0 0  c