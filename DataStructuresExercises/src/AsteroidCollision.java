import java.util.Arrays;
import java.util.LinkedList;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {};

        Arrays.stream(asteroidsCollision(asteroids))
                .forEach(System.out::println);

    }

    public static int[] asteroidsCollision(int[] asteroids){
        LinkedList<Integer> asteroidsList = new LinkedList<>();

        for (int asteroid : asteroids){
            asteroidsList.addLast(asteroid);

            if (asteroid<0){
                while (asteroidsList.size()>1){
                    int right = asteroidsList.removeLast();
                    int left = asteroidsList.removeLast();

                    if (left>0 && right<0){
                        if (left<right*-1){
                            asteroidsList.addLast(right);
                        }
                        if (left>right*-1){
                            asteroidsList.addLast(left);
                        }
                        if (left==right*-1){
                            asteroidsList.addLast(left);
                            asteroidsList.addLast(right);
                        }
                    }else {
                        asteroidsList.addLast(left);
                        asteroidsList.addLast(right);
                        break;
                    }
                }
            }
        }

        int[] result = new int[asteroidsList.size()];
        for (int i = 0; i < asteroidsList.size(); i++) {
            result[i]=asteroidsList.remove();
        }

        return result;
            }
}
