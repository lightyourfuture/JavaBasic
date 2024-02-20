public class MovieOperator {
    private Movie[] movies;

    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

// 1.展示电影全部信息
public void printAllMovies() {
    System.out.println("展示电影全部信息");
    for (int i = 0; i < movies.length; i++) {
        Movie movie = movies[i];
        if (movie != null) {
            System.out.println("电影id:" + movie.getId() + ", 电影名称:" + movie.getName() + ", 电影价格:" + movie.getPrice() + ", 电影评分:" + movie.getScore() + ", 导演:" + movie.getDirector() + ", 主演:" + movie.getActor() + ", 多少人想看:" + movie.getInfo());
        }
    }
}

    // 2.根据电影id查询电影详情
    public void searchMovieById(int id) {
        System.out.println("根据电影id查询电影详情");
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                System.out.printf("%-5s %-20s %-8s %-6s %-15s %-15s %s\n", "电影id", "电影名称", "电影价格", "电影评分", "导演", "主演", "多少人想看");
                System.out.printf("%-5d %-20s %-8.2f %-6.1f %-15s %-15s %s\n",
                        movie.getId(), movie.getName(), movie.getPrice(), movie.getScore(), movie.getDirector(), movie.getActor(), movie.getInfo());
            }
        }
    }

    // 3.根据电影名称查询电影详情
    public void getMovieByName(String name) {
        System.out.println("根据电影名称查询电影详情");
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                System.out.println("电影id\t电影名称\t电影价格\t电影评分\t导演\t主演\t多少人想看");
                System.out.println(movie.getId() + "\t" + movie.getName() + "\t" + movie.getPrice() + "\t" + movie.getScore() + "\t" + movie.getDirector() + "\t" + movie.getActor() + "\t" + movie.getInfo());
                return;
            }
        }
        System.out.println("没有找到该电影");

    }

// 4.根据电影id删除电影
public void deleteMovieById(int id) {
    System.out.println("根据电影id删除电影");
    for (int i = 0; i < movies.length; i++) {
        if (movies[i] != null && movies[i].getId() == id) {
            movies[i] = null;
        }
    }
}

    // 5.根据电影id修改电影信息
// 5.根据电影id修改电影信息
    public void updateMovieById(int id, Movie movie) {
        System.out.println("根据电影id修改电影信息");
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] != null && movies[i].getId() == id) {
                movies[i] = movie;
            }
        }
    }

    // 6.添加电影
    public void addMovie(Movie movie) {
        System.out.println("添加电影");
        for (int i = 0; i < movies.length; i++) {
            if (movies[i] == null) {
                movies[i] = movie;
                break;
            }
        }
    }

    // 7.根据电影评分排序
    public void sortMoviesByScore() {
        System.out.println("根据电影评分排序");
        for (int i = 0; i < movies.length - 1; i++) {
            for (int j = 0; j < movies.length - 1 - i; j++) {
                if (movies[j].getScore() < movies[j + 1].getScore()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }

    // 8.根据电影名称排序
    public void sortMoviesByName() {
        System.out.println("根据电影名称排序");
        for (int i = 0; i < movies.length - 1; i++) {
            for (int j = 0; j < movies.length - 1 - i; j++) {
                if (movies[j].getName().compareTo(movies[j + 1].getName()) > 0) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }

    // 9.根据电影价格排序
    public void sortMoviesByPrice() {
        System.out.println("根据电影价格排序");
        for (int i = 0; i < movies.length - 1; i++) {
            for (int j = 0; j < movies.length - 1 - i; j++) {
                if (movies[j].getPrice() > movies[j + 1].getPrice()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }

    // 10.根据电影id排序
    public void sortMoviesById() {
        System.out.println("根据电影id排序");
        for (int i = 0; i < movies.length - 1; i++) {
            for (int j = 0; j < movies.length - 1 - i; j++) {
                if (movies[j].getId() > movies[j + 1].getId()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }
}
