public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int j=0,k=0;
        if (this.age >= anotherCat.age)j++;
        else {k++;}
        if(this.weight >= anotherCat.weight)j++;
        else{k++;}
        if(this.strength >= anotherCat.strength)j++;
        else{k++;}

        if (j > k)return true;
        else return false;
        //напишите тут ваш код
    }

    public static void main(String[] args) {
		Cat belka = new Cat();
		belka.age = 3; belka.weight = 3; belka.strength = 3;
		Cat aliska = new Cat();
		aliska.age = 3; aliska.weight =3; aliska.strength =3;

        System.out.println(belka.fight(aliska));
        System.out.println(aliska.fight(belka));
    }
}
