package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Category;
import org.wecancoeit.reviews.model.Gym;
import org.wecancoeit.reviews.model.Hashtag;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.repos.CategoryRepository;
import org.wecancoeit.reviews.repos.GymRepository;
import org.wecancoeit.reviews.repos.HashtagRepository;
import org.wecancoeit.reviews.repos.ReviewRepository;

@Component
public class Populator implements CommandLineRunner {
    private ReviewRepository reviewRepo;
    private GymRepository gymRepo;
    private CategoryRepository categoryRepo;
    private HashtagRepository hashtagRepo;


    public Populator(ReviewRepository reviewRepo, GymRepository gymRepo, CategoryRepository categoryRepo, HashtagRepository hashtagRepo) {
        this.reviewRepo = reviewRepo;
        this.gymRepo = gymRepo;
        this.categoryRepo = categoryRepo;
        this.hashtagRepo = hashtagRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Category taekwondo = new Category("Taekwondo", "/images/TaeKwondo.jpg");
        Category kungFu = new Category("Kung Fu", "/images/KungFu.jpeg");
        Category bJJ = new Category("BJJ", "/images/BJJ.jpg");
        Category boxing = new Category("Boxing", "/images/Boxing.jpg");
        categoryRepo.save(taekwondo);
        categoryRepo.save(kungFu);
        categoryRepo.save(bJJ);
        categoryRepo.save(boxing);
        Hashtag hTTaekwondo = new Hashtag("#taekwondo");
        Hashtag hTKungFu = new Hashtag("#kungfu");
        Hashtag hTBJJ = new Hashtag("#bjj");
        Hashtag hTBoxing = new Hashtag("#boxing");
        hashtagRepo.save(hTTaekwondo);
        hashtagRepo.save(hTKungFu);
        hashtagRepo.save(hTBJJ);
        hashtagRepo.save(hTBoxing);
        Gym chaeTaeK = new Gym("Chae's Taekwondo", "/images/TaeKwondo.jpg", taekwondo, hTTaekwondo );
        Gym billBox = new Gym("Bill's Boxing", "/images/Boxing.jpeg", boxing, hTBoxing);
        Gym chaoKF = new Gym("Chao Kung Fu","/images/KungFu.jpeg", kungFu, hTKungFu);
        Gym gracyBJJ = new Gym("Gracy BJJ", "/images/BJJ.jpg",bJJ, hTBJJ);
        gymRepo.save(chaeTaeK);
        gymRepo.save(billBox);
        gymRepo.save(chaoKF);
        gymRepo.save(gracyBJJ);
        Review review1 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.","/images/profile-pic.jpeg", 2, gracyBJJ);
        Review review2 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.","/images/profile-pic.jpeg", 2, chaoKF);
        Review review3 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.","/images/profile-pic.jpeg", 2, billBox);
        Review review4 = new Review("BJJ_Guy_217","I've seen better!","The gym was not clean, and the facilities needed more equipment.","/images/profile-pic.jpeg", 2, chaeTaeK);
        reviewRepo.save(review1);
        reviewRepo.save(review2);
        reviewRepo.save(review3);
        reviewRepo.save(review4);

    }
}
