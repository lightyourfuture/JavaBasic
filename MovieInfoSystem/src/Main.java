import java.util.Scanner;

// 电影类
// 目标: 完成电影信息展示功能;根据电影id查询该电影详情
// 电影数据:
// 电影id  电影名称  电影价格  电影评分  导演  主演  多少人想看
// 1      《战狼2》  28.8     9.0    吴京  吴京  1000
// 2      《红海行动》  38.8  8.0    吴京  吴京  2000
// 3      《唐人街探案2》  58.8  7.0  陈思诚  王宝强  3000
// 4      《唐人街探案1》  48.8  6.0  陈思诚  王宝强  4000
// 5      《唐人街探案3》  68.8  5.0  陈思诚  王宝强  5000
public class Main {
    public static void main(String[] args) {
        // 1.设计一个电影类
        // 2.设计一个电影的操作类
        // 3.准备全部电影数据
        Movie movies[] = new Movie[5];
        movies[0] = new Movie(1, "《战狼2》", 28.8, 9.0, "吴京", "吴京", "1000");
        movies[1] = new Movie(2, "《红海行动》", 38.8, 8.0, "吴京", "吴京", "2000");
        movies[2] = new Movie(3, "《唐人街探案2》", 58.8, 7.0, "陈思诚", "王宝强", "3000");
        movies[3] = new Movie(4, "《唐人街探案1》", 48.8, 6.0, "陈思诚", "王宝强", "4000");
        movies[4] = new Movie(5, "《唐人街探案3》", 68.8, 5.0, "陈思诚", "王宝强", "5000");
        // 4.创建电影操作类对象，接受电影数据，并对其进行业务处管理
        MovieOperator movieOperator = new MovieOperator(movies);

        System.out.println("说明:本电影信息系统假设用户输入全部符合规范,不会出现输入错误的情况,请按照提示输入信息");
        System.out.println("简单的系统中,没有做异常处理,没有做数据持久化,没有做用户登录,没有做用户注册,没有做用户权限");
        System.out.println("电影容量为5,如果满了,请删除一部电影再添加新的电影");
        while (true) {
            // 5.展示电影信息系统
            System.out.println("------------------------");
            System.out.println("电影信息系统");
            System.out.println("1.展示电影全部信息");
            System.out.println("2.根据电影id查询电影详情");
            System.out.println("3.根据电影名称查询电影详情");
            System.out.println("4.根据电影id删除电影");
            System.out.println("5.根据电影id修改电影信息");
            System.out.println("6.添加电影");
            System.out.println("7.根据电影评分排序");
            System.out.println("8.根据电影名称排序");
            System.out.println("9.根据电影价格排序");
            System.out.println("------------------------");
            int id;
            String name;
            double price;
            double score;
            String director;
            String actor;
            String info;
            Movie movie;

            System.out.println("请输入你的选择");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    movieOperator.printAllMovies();
                    break;
                case 2:
                    System.out.println("请输入电影id");
                    id = new Scanner(System.in).nextInt();
                    movieOperator.searchMovieById(id);
                    break;
                case 3:
                    System.out.println("请输入电影名称");
                    name = new Scanner(System.in).nextLine();
                    movieOperator.getMovieByName(name);
                    break;
                case 4:
                    System.out.println("请输入电影id");
                    id = new Scanner(System.in).nextInt();
                    movieOperator.deleteMovieById(id);
                    break;
                case 5:
                    System.out.println("请输入电影id");
                    id = new Scanner(System.in).nextInt();
                    System.out.println("请输入电影名称");
                    name = new Scanner(System.in).nextLine();
                    System.out.println("请输入电影价格");
                    price = new Scanner(System.in).nextDouble();
                    System.out.println("请输入电影评分");
                    score = new Scanner(System.in).nextDouble();
                    System.out.println("请输入导演");
                    director = new Scanner(System.in).nextLine();
                    System.out.println("请输入主演");
                    actor = new Scanner(System.in).nextLine();
                    System.out.println("请输入多少人想看");
                    info = new Scanner(System.in).nextLine();
                    movie = new Movie(id, name, price, score, director, actor, info);
                    movieOperator.updateMovieById(id, movie);
                    break;
                case 6:
                    System.out.println("请输入电影id");
                    id = new Scanner(System.in).nextInt();
                    System.out.println("请输入电影名称");
                    name = new Scanner(System.in).nextLine();
                    System.out.println("请输入电影价格");
                    price = new Scanner(System.in).nextDouble();
                    System.out.println("请输入电影评分");
                    score = new Scanner(System.in).nextDouble();
                    System.out.println("请输入导演");
                    director = new Scanner(System.in).nextLine();
                    System.out.println("请输入主演");
                    actor = new Scanner(System.in).nextLine();
                    System.out.println("请输入多少人想看");
                    info = new Scanner(System.in).nextLine();
                    movie = new Movie(id, name, price, score, director, actor, info);
                    movieOperator.addMovie(movie);
                    break;
                case 7:
                    movieOperator.sortMoviesByScore();
                    break;
                case 8:
                    movieOperator.sortMoviesByName();
                    break;
                case 9:
                    movieOperator.sortMoviesByPrice();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }

    }
}
