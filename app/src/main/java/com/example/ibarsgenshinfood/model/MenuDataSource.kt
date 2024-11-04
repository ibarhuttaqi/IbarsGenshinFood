package com.example.ibarsgenshinfood.model

import com.example.ibarsgenshinfood.R

object MenuDataSource {
    val dummyMenus = listOf(
        Menu(
            id = 1,
            name = "Adeptus' Temptation",
            price = 15000,
            description = "A complex, famous type of Liyue cuisine. This dish is a rare and exquisite mix of both land and sea, combining countless delicious delicacies in one flavor-filled pot. Each mouthful is a moment to remember — it's even irresistible enough to entice the adepti down from their celestial abode.",
            effect = "Increases all party members' ATK by 372 and CRIT Rate by 12% for 300s.",
            quality = R.drawable.icon_5_stars,
            image = R.drawable.item_delicious_adeptus_temptation
        ),
        Menu(
            id = 2,
            name = "Pile 'Em Up",
            price = 2000,
            description = "A rich, meaty dish. Piled in just the right way to be both aesthetically pleasing and delicious all the way through. I wonder if we can pile it a little higher...",
            effect = "Increases all party members' CRIT Rate by 20% for 300s.",
            quality = R.drawable.icon_3_stars,
            image = R.drawable.item_delicious_pile_em_up
        ),
        Menu(
            id = 3,
            name = "Almond Tofu",
            price = 7000,
            description = "A dessert made from ground almonds. It has the exquisite look and texture of a piece of white jade, and could pass as an art piece — so much so that you could not entertain the idea of actually eating it.",
            effect = "Increases all party members' ATK by 95 for 300s.",
            quality = R.drawable.icon_2_stars,
            image = R.drawable.item_delicious_almond_tofu
        ),
        Menu(
            id = 4,
            name = "Apple Cider",
            price = 15000,
            description = "A freshly squeezed, fashionable, and fruity non-alcoholic beverage. Said to have a strong sobering effect, tavern patrons often order this as the last drink of the night.",
            effect = "Restores 26% of Max HP to the selected character and regenerates 570 HP every 5s for 30s.",
            quality = R.drawable.icon_2_stars,
            image = R.drawable.item_apple_cider
        ),
        Menu(
            id = 5,
            name = "Baklava",
            price = 9000,
            description = "A traditional Sumeru dessert. A certain researcher once said that the people of Sumeru can be split into two categories. Those who eat desserts to live, and those who live to eat desserts. The thin puff pastry layers of this dish, and the bone-piercing aroma of butter and honey, may yet consign all who taste it into the second camp.",
            effect = "Increases all party members' CRIT Rate by 20% for 300s.",
            quality = R.drawable.icon_3_stars,
            image = R.drawable.item_delicious_baklava
        ),
        Menu(
            id = 6,
            name = "Biryani",
            price = 4000,
            description = "An aromatic rice dish. The golden crown made of long-grain rice and meat is adorned with Padisarah petals, a picture that reminds you of a desert dotted with oases. The enticing scent of spices dances across each grain of rice. Every mouthful soothes your whole body. It won't take long for a customer to empty the plate. They can' help but lick their mouth, savoring the lingering scent.",
            effect = "Increases all party members' DEF by 308 and healing effects by 10% for 300s.",
            quality = R.drawable.icon_4_stars,
            image = R.drawable.item_delicious_biryani
        ),
        Menu(
            id = 7,
            name = "Calla Lily Seafood Soup",
            price = 8500,
            description = "A balanced combination of seafood. The crab, mint and calla lily come together perfectly to dance on your tongue. It reminds you of playing barefoot by the lake in summer.",
            effect = "Increases all party members' DEF by 235 for 300s.",
            quality = R.drawable.icon_3_stars,
            image = R.drawable.item_delicious_calla_lily_seafood_soup
        ),
        Menu(
            id = 8,
            name = "Chicken Tofu Pudding",
            price = 6000,
            description = "A dish that requires great precision to make. Successfully formed into a single block with no debris, it truly looks like tofu pudding. Its exquisite tenderness unravels on the tongue the moment it is scooped up with a porcelain spoon and fed into the mouth, and the taste is so sublime that it almost feels like having an out-of-body experience. What lies before you is no mere dish, but a gentle breeze, a pure spring, a stroke of the divine.",
            effect = "Increases all party members' ATK by 320 and CRIT Rate by 10% for 300s.",
            quality = R.drawable.icon_4_stars,
            image = R.drawable.item_delicious_chicken_tofu_pudding
        ),
        Menu(
            id = 9,
            name = "Crab, Ham & Veggie Bake",
            price = 9500,
            description = "A luxurious bake. The scent is so rich and heavenly. You'll only be done once you lick the plate clean.",
            effect = "Revives a character and restores 1,500 HP.",
            quality = R.drawable.icon_3_stars,
            image = R.drawable.item_delicious_crab_veggie_bake
        ),
        Menu(
            id = 10,
            name = "Crab Roe Tofu",
            price = 8500,
            description = "A dish with a tender mouthfeel. The tofu is so tender that it might break if you blew on a spoonful of it. Each granule of the crab roe is plump and filled with crab oil that oozes out onto your lips the moment you have a single bite. Chewing is not needed at all. The food travels down your gullet in a flash, leaving nothing but the memory of its fresh flavor",
            effect = "Revives a character and restores 550 HP.",
            quality = R.drawable.icon_2_stars,
            image = R.drawable.item_delicious_crab_roe_tofu
        ),
        Menu(
            id = 11,
            name = "Crystal Shrimp",
            price = 6000,
            description = "One of Liyue's traditional snacks. The outer skin is as clear as its crystal namesake, and when it enters the mouth, one's tongue could be forgiven for thinking that the fresh shrimp within is still alive. Those who eat it can only lament that four pieces per serving is far, far too few.",
            effect = "Restores 22% of Max HP to the selected character and regenerates 470 HP every 5s for 30s.",
            quality = R.drawable.icon_2_stars,
            image = R.drawable.item_delicious_crystal_shrimp
        ),
        Menu(
            id = 12,
            name = "Golden Crab",
            price = 7000,
            description = "A crab dish cooked in the ancient ways. The aroma of the crab meat inundates the room the instant it leaves the frying pan, and a single bite fills one's palate with the countless rustic flavors of a fishing village hometown. It seems that such simple yet timeless village customs held the secret to this lavish, golden sumptuousness all along.",
            effect = "Increases all party members' DEF by 308 and healing effects by 10% for 300s.",
            quality = R.drawable.icon_4_stars,
            image = R.drawable.item_delicious_golden_crab
        ),
        Menu(
            id = 13,
            name = "Golden Shrimp Balls",
            price = 12000,
            description = "A deep-fried shrimp dish. From the rich, indulgent scent of crispy golden potato strips, to the satisfying crunch as you take your first bite, to the grand finale of delicious sweet shrimp, this dish is pure pleasure.",
            effect = "Revives a character and restores 1,500 HP.",
            quality = R.drawable.icon_3_stars,
            image = R.drawable.item_delicious_golden_shrimp_balls
        ),
        Menu(
            id = 14,
            name = "Goulash",
            price = 11000,
            description = "A steaming-hot stew. Just one spoonful sends a down-to-earth sense of satisfaction welling up from the depths of your heart. The meat's flavor grows with every chew, bringing limitless strength to the eater even in the coldest wintry wastes.",
            effect = "Decreases the rate of Sheer Cold accumulation for all party members for 900s.",
            quality = R.drawable.icon_2_stars,
            image = R.drawable.item_delicious_goulash
        ),
        Menu(
            id = 15,
            name = "Jade Parcels",
            price = 11000,
            description = "An exquisite-looking dish. The sweetness of ham and the crisp lotus seeds are a match made in heaven. The aromatic broth pours down like the dawning light, caressing your tongue with an unworldly delicious taste.",
            effect = "Increases all party members' ATK by 320 and CRIT Rate by 10% for 300s.",
            quality = R.drawable.icon_4_stars,
            image = R.drawable.item_delicious_jade_parcels
        ),
        Menu(
            id = 16,
            name = "Jueyun Chili Chicken",
            price = 11000,
            description = "Chicken in a dressing, served cold. The chicken is extremely tender, juicy, and sweet. The delicious taste transports you to the realm of dreams.",
            effect = "Increases all party members' CRIT Rate by 12% for 300s.",
            quality = R.drawable.icon_2_stars,
            image = R.drawable.item_delicious_jueyun_chili_chicken
        ),
    )
}
