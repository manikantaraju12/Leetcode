import java.util.*;

class MovieRentingSystem {

    class MovieEntry implements Comparable<MovieEntry> {
        int shop, price;
        MovieEntry(int shop, int price) {
            this.shop = shop;
            this.price = price;
        }
        public int compareTo(MovieEntry other) {
            if (this.price != other.price) return this.price - other.price;
            return this.shop - other.shop;
        }
    }

    class RentedEntry implements Comparable<RentedEntry> {
        int shop, movie, price;
        RentedEntry(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
        public int compareTo(RentedEntry other) {
            if (this.price != other.price) return this.price - other.price;
            if (this.shop != other.shop) return this.shop - other.shop;
            return this.movie - other.movie;
        }
    }

    private Map<Integer, TreeSet<MovieEntry>> available;
   
    private TreeSet<RentedEntry> rented;
    
    private Map<String, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>();
        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "," + movie, price);

            available.putIfAbsent(movie, new TreeSet<>());
            available.get(movie).add(new MovieEntry(shop, price));
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;

        TreeSet<MovieEntry> set = available.get(movie);
        int count = 0;
        for (MovieEntry me : set) {
            if (count == 5) break;
            res.add(me.shop);
            count++;
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "," + movie);
        available.get(movie).remove(new MovieEntry(shop, price));
        rented.add(new RentedEntry(shop, movie, price));
    }
    
    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "," + movie);
        rented.remove(new RentedEntry(shop, movie, price));
        available.get(movie).add(new MovieEntry(shop, price));
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (RentedEntry re : rented) {
            if (count == 5) break;
            res.add(Arrays.asList(re.shop, re.movie));
            count++;
        }
        return res;
    }
}
