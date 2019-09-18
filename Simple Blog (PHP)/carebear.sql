-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 23, 2019 at 04:05 PM
-- Server version: 10.3.14-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carebear`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `cmnt_id` int(10) NOT NULL,
  `cuser_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cpost_id` int(10) UNSIGNED DEFAULT NULL,
  `cmnt_content` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `cmnt_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`cmnt_id`, `cuser_name`, `cpost_id`, `cmnt_content`, `cmnt_date`) VALUES
(4, 'she', 7, 'what is this ?', '2019-04-20 05:38:25');

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `post_id` int(10) UNSIGNED NOT NULL,
  `post_author` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_content` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `post_date` datetime DEFAULT NULL,
  `post_img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`post_id`, `post_author`, `post_title`, `post_content`, `post_date`, `post_img`) VALUES
(6, 'amitb', 'That Darn Katz', '<h2>Xmas Story</h2>\r\n<p>It must be wonderful. Does anybody else feel jealous and aroused and worried? Is today\'s hectic lifestyle making you tense and impatient? Soothe us with sweet lies. That\'s right, baby. I ain\'t your loverboy Flexo, the guy you love so much. You even love anyone pretending to be him!</p>\r\n<ul>\r\n<li>Goodbye, friends. I never thought I\'d die like this. But I always really hoped.</li>\r\n<li>They\'re like sex, except I\'m having them!</li>\r\n<li>Come, Comrade Bender! We must take to the streets!</li>\r\n</ul>\r\n<h3>Anthology of Interest I</h3>\r\n<p>Hey, whatcha watching? They\'re like sex, except I\'m having them! Well I\'da done better, but it\'s plum hard pleading a case while awaiting trial for that there incompetence. Yes, except the Dave Matthews Band doesn\'t rock. I suppose I could part with \'one\' and still be feared&hellip;</p>\r\n<h4>Teenage Mutant Leela\'s Hurdles</h4>\r\n<p>Oh, but you can. But you may have to metaphorically make a deal with the devil. And by \"devil\", I mean Robot Devil. And by \"metaphorically\", I mean get your coat. Please, Don-Bot&hellip; look into your hard drive, and open your mercy file! It\'s a T. It goes \"tuh\". I guess if you want children beaten, you have to do it yourself.</p>\r\n<ol>\r\n<li>Spare me your space age technobabble, Attila the Hun!</li>\r\n<li>Well, thanks to the Internet, I\'m now bored with sex. Is there a place on the web that panders to my lust for violence?</li>\r\n</ol>\r\n<h5>The Farnsworth Parabox</h5>\r\n<p>Wow! A superpowers drug you can just rub onto your skin? You\'d think it would be something you\'d have to freebase. We need rest. The spirit is willing, but the flesh is spongy and bruised. It must be wonderful.</p>', '2019-04-20 10:44:30', 'img3'),
(7, 'amitb', 'How Hermes Requisitioned His Groove Back', '<h2>The Luck of the Fryrish</h2>\r\n<p>Professor, make a woman out of me. I am the man with no name, Zapp Brannigan! Good man. Nixon\'s pro-war and pro-family. The alien mothership is in orbit here. If we can hit that bullseye, the rest of the dominoes will fall like a house of cards. Checkmate. Fry, you can\'t just sit here in the dark listening to classical music.</p>\r\n<ul>\r\n<li>Who are those horrible orange men?</li>\r\n<li>Is today\'s hectic lifestyle making you tense and impatient?</li>\r\n</ul>\r\n<h3>Lethal Inspection</h3>\r\n<p>Oh, but you can. But you may have to metaphorically make a deal with the devil. And by \"devil\", I mean Robot Devil. And by \"metaphorically\", I mean get your coat. No. We\'re on the top. Does anybody else feel jealous and aroused and worried? Well I\'da done better, but it\'s plum hard pleading a case while awaiting trial for that there incompetence. It must be wonderful.</p>\r\n<h4>Where No Fan Has Gone Before</h4>\r\n<p>Who are those horrible orange men? Bender, we\'re trying our best. Please, Don-Bot&hellip; look into your hard drive, and open your mercy file! Wow! A superpowers drug you can just rub onto your skin? You\'d think it would be something you\'d have to freebase. WINDMILLS DO NOT WORK THAT WAY! GOOD NIGHT! Look, last night was a mistake.</p>\r\n<ol>\r\n<li>I\'m sorry, guys. I never meant to hurt you. Just to destroy everything you ever believed in.</li>\r\n<li>Stop it, stop it. It\'s fine. I will \'destroy\' you!</li>\r\n<li>You guys realize you live in a sewer, right?</li>\r\n</ol>\r\n<h5>Fear of a Bot Planet</h5>\r\n<p>Why yes! Thanks for noticing. Hey, guess what you\'re accessories to. Yes, except the Dave Matthews Band doesn\'t rock. Take me to your leader! Daddy Bender, we\'re hungry.</p>', '2019-04-20 00:00:00', 'img2'),
(10, 'amitb', 'Creating a blog from scratch with PHP', 'oifj;asldk;aisdu[pwenfkl;dshfadyfpoadfalkdsfj', '2019-04-20 11:36:53', 'img3');

-- --------------------------------------------------------

--
-- Table structure for table `submissions`
--

CREATE TABLE `submissions` (
  `spost_id` int(10) UNSIGNED NOT NULL,
  `spost_author` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `spost_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `spost_content` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `spost_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `submissions`
--

INSERT INTO `submissions` (`spost_id`, `spost_author`, `spost_title`, `spost_content`, `spost_date`) VALUES
(2, 'user', 'I have a problem', '<h3>I have cancer</h3>\r\n<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Illum et, temporibus deleniti dolorum fugit at totam laborum explicabo inventore accusamus. Mollitia earum ab excepturi, adipisci, quod perspiciatis est soluta dolor at iste, optio modi temporibus deserunt quaerat sapiente velit eos. Optio magnam voluptas numquam asperiores repudiandae voluptatibus suscipit at eos?<p>', '2019-04-15 05:19:23'),
(3, 'user2', 'I have a problem too', '<h3>I have AIDS</h3>\r\n<p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Illum et, temporibus deleniti dolorum fugit at totam laborum explicabo inventore accusamus. Mollitia earum ab excepturi, adipisci, quod perspiciatis est soluta dolor at iste, optio modi temporibus deserunt quaerat sapiente velit eos. Optio magnam voluptas numquam asperiores repudiandae voluptatibus suscipit at eos?</p>', '2019-04-15 05:22:32');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(10) UNSIGNED NOT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_pass` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_addr` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_dob` date DEFAULT NULL,
  `user_blood` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_or_doctor` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_first_Name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_last_Name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `user_pass`, `user_email`, `user_addr`, `user_dob`, `user_blood`, `user_or_doctor`, `user_first_Name`, `user_last_Name`) VALUES
(1, 'amitb', '$2y$10$bCGQ22dVwlEKG3oi5YeybOkbxzkwpFzyRNkgeCeEGa6Ki6qBDfziy', 'amitb@gmail.com', 'Dhaka', NULL, 'B+ve', 'doctor', 'Amit', 'Biswas'),
(2, 'user', '$2y$10$.jw6TDNpFaocJIrDVSZlMO0jTqx4aS/Vvai3P2gOIj8E3eR4EjLve', 'amitb@gmail.com', 'Bhola', NULL, 'A+ve', 'user', 'Nehad', 'Awad'),
(3, 'user2', '$2y$10$W4TwHrA4.cWpM0FfGD1QlexN/ddHCsVpEKb0.sgwEfzfPpPwa10NC', 'amitb@gmail.com', 'Badda', NULL, 'AB+', 'user', 'Nasif', 'Zaman'),
(4, 'she', '$2y$10$09FEVqbk4WKQPup6HvP8NOdb0nN2I7cP9x0NJnqS1GXSbb6reI/Ne', 'she@gmail.com', 'null', NULL, 'AB+', 'doctor', 'no', 'fn');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`cmnt_id`),
  ADD KEY `cuser_name` (`cuser_name`),
  ADD KEY `cpost_id` (`cpost_id`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `post_author` (`post_author`);

--
-- Indexes for table `submissions`
--
ALTER TABLE `submissions`
  ADD PRIMARY KEY (`spost_id`),
  ADD KEY `spost_author` (`spost_author`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_name` (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `cmnt_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `post_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `submissions`
--
ALTER TABLE `submissions`
  MODIFY `spost_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`cuser_name`) REFERENCES `users` (`user_name`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`cpost_id`) REFERENCES `posts` (`post_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`post_author`) REFERENCES `users` (`user_name`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `submissions`
--
ALTER TABLE `submissions`
  ADD CONSTRAINT `submissions_ibfk_1` FOREIGN KEY (`spost_author`) REFERENCES `users` (`user_name`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
