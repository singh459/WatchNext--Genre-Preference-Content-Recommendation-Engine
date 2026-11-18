
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] titles = new String[100];
        String[] genres = new String[100];
        String[] languages = new String[100];

        int contentCount = 0;

        String[] watchedTitles = new String[100];
        int[] ratings = new int[100];
        LocalDate[] watchedDates = new LocalDate[100];

        int watchedCount = 0;

        boolean running = true;

        System.out.println("================================");
        System.out.println("       WELCOME TO WATCHNEXT");
        System.out.println(" Genre-Preference Recommendation");
        System.out.println("================================");

        while (running) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Add New Content");
            System.out.println("2. View All Content");
            System.out.println("3. Record Watched Content and Rating");
            System.out.println("4. View Watch History");
            System.out.println("5. Calculate Genre Preferences");
            System.out.println("6. Get Top 5 Recommendations");
            System.out.println("7. View Trending Content (Last 7 Days)");
            System.out.println("8. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (contentCount < titles.length) {

                        sc.nextLine();

                        System.out.print("Enter Content Title: ");
                        titles[contentCount] = sc.nextLine();

                        System.out.print("Enter Genre: ");
                        genres[contentCount] = sc.nextLine();

                        System.out.print("Enter Language: ");
                        languages[contentCount] = sc.nextLine();

                        contentCount++;

                        System.out.println("Content added successfully!");

                    } else {
                        System.out.println("Content storage is full!");
                    }
                    break;

                case 2:
                    if (contentCount == 0) {

                        System.out.println("No content available!");

                    } else {

                        System.out.println("\n========== ALL CONTENT ==========");

                        for (int i = 0; i < contentCount; i++) {

                            System.out.println("\nContent " + (i + 1));
                            System.out.println("Title: " + titles[i]);
                            System.out.println("Genre: " + genres[i]);
                            System.out.println("Language: " + languages[i]);
                        }
                    }
                    break;

                case 3:
                    if (contentCount == 0) {

                        System.out.println("Please add content first!");

                    } else if (watchedCount == watchedTitles.length) {

                        System.out.println("Watch history is full!");

                    } else {

                        System.out.println("\n========== AVAILABLE CONTENT ==========");

                        for (int i = 0; i < contentCount; i++) {
                            System.out.println((i + 1) + ". " + titles[i]);
                        }

                        System.out.print("Select content number: ");
                        int contentChoice = sc.nextInt();

                        if (contentChoice < 1 || contentChoice > contentCount) {

                            System.out.println("Invalid content number!");

                        } else {

                            System.out.print("Enter your rating (1-10): ");
                            int rating = sc.nextInt();

                            if (rating < 1 || rating > 10) {

                                System.out.println("Invalid rating! Enter a rating from 1 to 10.");

                            } else {

                                watchedTitles[watchedCount] =
                                        titles[contentChoice - 1];

                                ratings[watchedCount] = rating;
                                watchedDates[watchedCount] = LocalDate.now();

                                watchedCount++;

                                System.out.println("Watched content recorded successfully!");
                            }
                        }
                    }
                    break;

                case 4:
                    if (watchedCount == 0) {

                        System.out.println("Your watch history is empty!");

                    } else {

                        System.out.println("\n========== WATCH HISTORY ==========");

                        for (int i = 0; i < watchedCount; i++) {

                            System.out.println("\nWatched Content " + (i + 1));
                            System.out.println("Title: " + watchedTitles[i]);
                            System.out.println("Rating: " + ratings[i] + "/10");
                            System.out.println("Date: " + watchedDates[i]);
                        }
                    }
                    break;

                case 5:
                    if (watchedCount == 0) {

                        System.out.println("Please record watched content first!");

                    } else {

                        System.out.println("\n========== GENRE PREFERENCES ==========");

                        for (int i = 0; i < contentCount; i++) {

                            boolean genreAlreadyShown = false;

                            for (int j = 0; j < i; j++) {

                                if (genres[i].equalsIgnoreCase(genres[j])) {
                                    genreAlreadyShown = true;
                                    break;
                                }
                            }

                            if (!genreAlreadyShown) {

                                int totalRating = 0;
                                int ratingCount = 0; 

                                for (int w = 0; w < watchedCount; w++) {

                                    for (int c = 0; c < contentCount; c++) {

                                        if (watchedTitles[w].equalsIgnoreCase(titles[c])
                                                && genres[c].equalsIgnoreCase(genres[i])) {

                                            totalRating += ratings[w];
                                            ratingCount++;
                                            break;
                                        }
                                    }
                                }

                                if (ratingCount > 0) {

                                    double preferenceScore =
                                            (double) totalRating / ratingCount;

                                    System.out.println("\nGenre: " + genres[i]);
                                    System.out.println("Preference Score: "
                                            + preferenceScore + "/10");
                                    System.out.println("--------------------------------");
                                }
                            }
                        }
                    }
                    break;

                case 6:

                    if (watchedCount == 0) {

                        System.out.println("Please record watched content first!");

                    } else if (contentCount == watchedCount) {

                        System.out.println("No unwatched content available!");

                    } else {

                        double[] scores = new double[contentCount];
                        boolean[] watched = new boolean[contentCount];

                        for (int i = 0; i < contentCount; i++) {

                            for (int j = 0; j < watchedCount; j++) {

                                if (titles[i].equalsIgnoreCase(watchedTitles[j])) {
                                    watched[i] = true;
                                    break;
                                }
                            }
                        }

                        for (int i = 0; i < contentCount; i++) {

                            int totalRating = 0;
                            int ratingCount = 0;

                            for (int j = 0; j < watchedCount; j++) {

                                for (int k = 0; k < contentCount; k++) {

                                    if (watchedTitles[j].equalsIgnoreCase(titles[k])
                                            && genres[k].equalsIgnoreCase(genres[i])) {

                                        totalRating += ratings[j];
                                        ratingCount++;
                                        break;
                                    }
                                }
                            }

                            if (ratingCount > 0) {
                                scores[i] = (double) totalRating / ratingCount;
                            } else {
                                scores[i] = 0;
                            }
                        }

                        int[] recommended = new int[contentCount];
                        int recommendationCount = 0;

                        for (int i = 0; i < contentCount; i++) {

                            if (!watched[i] && scores[i] > 0) {

                                recommended[recommendationCount] = i;
                                recommendationCount++;
                            }
                        }

                        for (int i = 0; i < recommendationCount - 1; i++) {

                            for (int j = i + 1; j < recommendationCount; j++) {

                                if (scores[recommended[j]] > scores[recommended[i]]) {

                                    int temp = recommended[i];
                                    recommended[i] = recommended[j];
                                    recommended[j] = temp;
                                }
                            }
                        }

                        if (recommendationCount == 0) {

                            System.out.println("No recommendations available!");

                        } else {

                            System.out.println("\n========== TOP 5 RECOMMENDATIONS ==========");

                            int limit = Math.min(5, recommendationCount);

                            for (int i = 0; i < limit; i++) {

                                int index = recommended[i];

                                System.out.println("\nRecommendation " + (i + 1));
                                System.out.println("Title: " + titles[index]);
                                System.out.println("Genre: " + genres[index]);
                                System.out.println("Language: " + languages[index]);
                                System.out.println("Preference Score: "
                                        + scores[index] + "/10");
                            }
                        }
                    }
                    break;

                case 7:

                    if (watchedCount == 0) {

                        System.out.println("No views recorded yet!");

                    } else {

                        LocalDate today = LocalDate.now();
                        LocalDate lastWeek = today.minusDays(6);

                        int[] viewCounts = new int[contentCount];
                        int[] trending = new int[contentCount];

                        for (int i = 0; i < contentCount; i++) {

                            for (int j = 0; j < watchedCount; j++) {

                                if (titles[i].equalsIgnoreCase(watchedTitles[j])
                                        && !watchedDates[j].isBefore(lastWeek)
                                        && !watchedDates[j].isAfter(today)) {

                                    viewCounts[i]++;
                                }
                            }

                            trending[i] = i;
                        }

                        for (int i = 0; i < contentCount - 1; i++) {

                            for (int j = i + 1; j < contentCount; j++) {

                                if (viewCounts[trending[j]] > viewCounts[trending[i]]) {

                                    int temp = trending[i];
                                    trending[i] = trending[j];
                                    trending[j] = temp;
                                }
                            }
                        }

                        System.out.println("\n========== TRENDING CONTENT ==========");
                        System.out.println("Last 7 Days");

                        boolean found = false;

                        for (int i = 0; i < contentCount; i++) {

                            int index = trending[i];

                            if (viewCounts[index] > 0) {

                                found = true;

                                System.out.println("\nTitle: " + titles[index]);
                                System.out.println("Genre: " + genres[index]);
                                System.out.println("Views: " + viewCounts[index]);
                            }
                        }

                        if (!found) {
                            System.out.println("No trending content available!");
                        }
                    }
                    break;

                case 8:
                    System.out.println("Thank you for using WatchNext!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1 to 8.");
            }
        }

        sc.close();
    }
}
