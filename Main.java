package relran;

public class Main {
    public static void main(String[] args) {
        OurList<Integer> list  = new OurArrayList<>();
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(9);
        System.out.println("Check method get: "+list.get(0));
        System.out.println("Check method size: "+list.size());
        System.out.println("Check method remove: "+list.remove(1));
        try {
            System.out.println("Check method get: "+list.get(1));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        System.out.println("Check method remove Object: "+list.remove((Integer) 7));
        System.out.println("Check method contain: "+list.contains(7));
        System.out.println("Check method set: "+list.set(0,7));
        System.out.println("Check method size: "+list.size());

        for(int number : list){
            System.out.print(number+" ");
        }






    }


}
