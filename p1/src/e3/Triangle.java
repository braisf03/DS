package e3;

import e1.DateUtilities;

import java.util.*;
import java.lang.Math;

public record Triangle(float angle0, float angle1, float angle2) {

    public Triangle(float angle0, float angle1, float angle2) {

        if (angle0 + angle1 + angle2 != 180) {
            throw new IllegalArgumentException("Angles do not sum 180");
        } else {
            this.angle0 = angle0;
            this.angle1 = angle1;
            this.angle2 = angle2;
        }


    }

    public Triangle(Triangle t) {

        this(t.angle0(), t.angle1(), t.angle2());
    }

    public boolean isRight() {

        return angle0 == 90 ^ angle1 == 90 ^ angle2 == 90;
    }

    public boolean isAcute() {

        return angle0 < 90 && angle1 < 90 && angle2 < 90;
    }

    public boolean isObtuse() {

        return angle0 > 90 ^ angle1 > 90 ^ angle2 > 90;

    }

    public boolean isEquilateral() {

        return (angle0 == angle1) && (angle0 == angle2) && (angle2 == angle1);
    }

    public boolean isIsosceles() {

        return (angle0 == angle1) || (angle0 == angle2) || (angle2 == angle1);
    }

    public boolean isScalene() {

        return (angle0 != angle1) && (angle0 != angle2) && (angle2 != angle1);
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        else if (o == null) return false;

        if (this.getClass() != o.getClass()) return false;

        Triangle t = (Triangle) o;

        if (t.isEquilateral() && isEquilateral()) {

            return true;
        }


        //ni idea de como se comparan todos los angulos wacho

        float[] angles0 = {angle0, angle1, angle2};
        List<Float> angles1 = new LinkedList<>();

        angles1.add(t.angle0);
        angles1.add(t.angle1);
        angles1.add(t.angle2);


        boolean finded = false;


        for (float a : angles0) {

            finded = false;

            for (float b : angles1) {

                if (a == b) {

                    angles1.remove(b);
                    finded = true;
                    break;
                }
            }
            if (!finded) {

                return false;
            }

        }


        return true;


    }

    @Override
    public int hashCode() {

        float[] angles = {angle0,angle1,angle2};

        Arrays.sort(angles);

        
        float result = angles[0];
        result = 31 * result + angles[1];
        result = 31  * result + angles[2];
        return Math.round(result);
    }


}
