package com.example.week1.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class CountryDetailsModel implements Parcelable {

    String name;
    String desc;

    public CountryDetailsModel(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static List<CountryDetailsModel>  getCountryDemoList(){

        List<CountryDetailsModel> countryDetailModels = new ArrayList<>();

        countryDetailModels.add(new CountryDetailsModel("Nepal", "Nepal (Nepali: नेपाल, ISO:Nēpāl), officially Federal Democratic Republic of Nepal,[11] is a landlocked country in South Asia. It is located mainly in the Himalayas, but also includes parts of the Indo-Gangetic Plain. With an estimated population of 26.4 million, it is 48th largest country by population and 93rd largest country by area.[7][12] It borders China in the north and India in the south, east and west while Bangladesh is located within only 27 km (17 mi) of its southeastern tip and Bhutan is separated from it by the Indian state of Sikkim. Nepal has a diverse geography, including fertile plains,[13] subalpine forested hills, and eight of the world's ten tallest mountains, including Mount Everest, the highest point on Earth. Kathmandu is the capital and the largest city. Nepal is a multiethnic country with Nepali as the official language."));
        countryDetailModels.add(new CountryDetailsModel("China", "China emerged as one of the world's first civilizations, in the fertile basin of the Yellow River in the North China Plain. For millennia, China's political system was based on hereditary monarchies, or dynasties, beginning with the semi-legendary Xia dynasty in 21st century BCE.[18] Since then, China has expanded, fractured, and re-unified numerous times. In the 3rd century BCE, the Qin reunited core China and established the first Chinese empire. The succeeding Han dynasty, which ruled from 206 BC until 220 AD, saw some of the most advanced technology at that time, including papermaking and the compass,[19] along with agricultural and medical improvements. The invention of gunpowder and movable type in the Tang dynasty (618–907) and Northern Song (960–1127) completed the Four Great Inventions. Tang culture spread widely in Asia, as the new Silk Route brought traders to as far as Mesopotamia and the Horn of Africa.[20] Dynastic rule ended in 1912 with the Xinhai Revolution, when the republic replaced the Qing dynasty. China as a whole was ravaged by Japan during World War II, and the subsequent Chinese Civil War resulted in a division of territory in 1949, when the Communist Party of China established the People's Republic of China, a unitary one-party sovereign state on the majority of China, while the Kuomintang-led nationalist government retreated to the island of Taiwan. The political status of Taiwan remains disputed."));
        countryDetailModels.add(new CountryDetailsModel("Australia", "Australia is a highly developed country, with the world's 14th-largest economy. It has a high-income economy, with the world's tenth-highest per capita income.[26] It is a regional power and has the world's 13th-highest military expenditure.[27] Australia has the world's eighth-largest immigrant population, with immigrants accounting for 29% of the population.[28][29] Having the third-highest human development index and the eighth-highest ranked democracy globally, the country ranks highly in quality of life, health, education, economic freedom, civil liberties and political rights,[30] with all its major cities faring well in global comparative livability surveys.[31] Australia is a member of the United Nations, G20, Commonwealth of Nations, ANZUS, Organisation for Economic Co-operation and Development (OECD), World Trade Organization, Asia-Pacific Economic Cooperation, Pacific Islands Forum, and the ASEAN Plus Six mechanism."));
        countryDetailModels.add(new CountryDetailsModel("Portugal", "Portugal is the oldest nation state on the Iberian Peninsula and one of the oldest in Europe, its territory having been continuously settled, invaded and fought over since prehistoric times. The pre-Celtic people, Celts, Carthaginians and Romans were followed by the invasions of the Visigoths and Suebi Germanic peoples. Portugal as a country was established during the Christian Reconquista against the Moors who had invaded the Iberian Peninsula in 711 AD. Founded in 868, the County of Portugal gained prominence after the Battle of São Mamede in 1128. The Kingdom of Portugal was later proclaimed following the Battle of Ourique in 1139, and independence from León was recognised by the Treaty of Zamora in 1143.[11]"));
        countryDetailModels.add(new CountryDetailsModel("America", "The United States is the world's oldest surviving federation. It is a federal republic and a representative democracy. The United States is a founding member of the United Nations, World Bank, International Monetary Fund, Organization of American States (OAS), and other international organizations. The United States is a highly developed country, with the world's largest economy by nominal GDP and second-largest economy by PPP, accounting for approximately a quarter of global GDP.[28] The U.S. economy is largely post-industrial, characterized by the dominance of services and knowledge-based activities, although the manufacturing sector remains the second-largest in the world.[29] The United States is the world's largest importer and the second-largest exporter of goods, by value.[30][31] Although its population is only 4.3% of the world total,[32] the U.S. holds 31% of the total wealth in the world, the largest share of global wealth concentrated in a single country.[33]"));
        countryDetailModels.add(new CountryDetailsModel("NewZealand", "New Zealand (Māori: Aotearoa [aɔˈtɛaɾɔa]) is a sovereign island country in the southwestern Pacific Ocean. The country geographically comprises two main landmasses—the North Island (Te Ika-a-Māui), and the South Island (Te Waipounamu)—and around 600 smaller islands. It has a total land area of 268,000 square kilometres (103,500 sq mi). New Zealand is situated some 2,000 kilometres (1,200 mi) east of Australia across the Tasman Sea and roughly 1,000 kilometres (600 mi) south of the Pacific island areas of New Caledonia, Fiji, and Tonga. Because of its remoteness, it was one of the last lands to be settled by humans. During its long period of isolation, New Zealand developed a distinct biodiversity of animal, fungal, and plant life. The country's varied topography and its sharp mountain peaks, such as the Southern Alps, owe much to the tectonic uplift of land and volcanic eruptions. New Zealand's capital city is Wellington, while its most populous city is Auckland."));
        countryDetailModels.add(new CountryDetailsModel("Hongkong", "Hong Kong is classified as an alpha+ global city, indicating its influence throughout the world.[27] It is one of the most significant global financial centres, holding the highest Financial Development Index score and consistently ranking as the most competitive and freest economic area in the world (2012, 2016, 2017).[20][28] The city has the largest number of skyscrapers, most surrounding Victoria Harbour.[29] On the Human Development Index, it ranks the highest in Asia and seventh in the world, and it has one of the world's highest life expectancies.[30] Over 90 percent of its population uses public transportation; however, air pollution from neighbouring industrial areas of mainland China has caused a high level of atmospheric particulates in the region.[31][32]"));
        countryDetailModels.add(new CountryDetailsModel("Spain", "Spain is a secular parliamentary democracy and a parliamentary monarchy,[16] with King Felipe VI as head of state. It is a major developed country[17] and a high income country, with the world's fourteenth largest economy by nominal GDP and sixteenth largest by purchasing power parity. It is a member of the United Nations (UN), the European Union (EU), the Eurozone, the Council of Europe (CoE), the Organization of Ibero-American States (OEI), the Union for the Mediterranean, the North Atlantic Treaty Organization (NATO), the Organisation for Economic Co-operation and Development (OECD), Organization for Security and Co-operation in Europe (OSCE), the Schengen Area, the World Trade Organization (WTO) and many other international organisations. While not an official member, Spain has a \"Permanent Invitation\" to the G20 summits, participating in every summit, which makes Spain a de facto member of the group.[18]"));
        countryDetailModels.add(new CountryDetailsModel("Brazil", "Brazil is considered an advanced emerging economy.[18] It has the ninth largest GDP in the world by nominal, and eight by PPP measures.[19][20] It is one of the world's major breadbaskets, being the largest producer of coffee for the last 150 years.[21] It is classified as an upper-middle income economy by the World Bank[22] and a newly industrialized country,[23][24] with the largest share of global wealth in Latin America. Brazil is a regional power and sometimes considered a great[25][26][27] or a middle power in international affairs.[27][28][29][30][31][26] On account of its international recognition and influence, the country is subsequently classified as an emerging power[32] and a potential superpower by several analysts.[33][34][35] Brazil is a founding member of the United Nations, the G20, BRICS, Union of South American Nations, Mercosul, Organization of American States, Organization of Ibero-American States and the Community of Portuguese Language Countries."));
        countryDetailModels.add(new CountryDetailsModel("Germany", "Germany includes 16 constituent states, covers an area of 357,386 square kilometres (137,988 sq mi),[7] and has a largely temperate seasonal climate. With 83 million inhabitants, it is the second most populous state of Europe after Russia, the most populous state lying entirely in Europe, as well as the most populous member state of the European Union. Germany is a very decentralised country. Its capital and largest metropolis is Berlin, while Frankfurt serves as its financial capital and has the country's busiest airport. Germany's largest urban area is the Ruhr, with its main centres of Dortmund and Essen. The country's other major cities are Hamburg, Munich, Cologne, Stuttgart, Düsseldorf, Leipzig, Bremen, Dresden, Hanover, and Nuremberg."));
        countryDetailModels.add(new CountryDetailsModel("Netherlands", "Netherlands literally means 'lower countries' in reference to its low elevation and flat topography, with only about 50% of its land exceeding 1 metre (3 ft 3 in) above sea level, and nearly 17% falling below sea level.[16] Most of the areas below sea level, known as polders, are the result of land reclamation that began in the 16th century. With a population of 17.34 million people, all living within a total area of roughly 41,500 square kilometres (16,000 sq mi)—of which the land area is 33,700 square kilometres (13,000 sq mi)—the Netherlands is one of the most densely populated countries in the world. Nevertheless, it is the world's second-largest exporter of food and agricultural products (after the United States), owing to its fertile soil, mild climate, and intensive agriculture.[17][18]"));
        countryDetailModels.add(new CountryDetailsModel("India", "India is a secular federal republic governed in a democratic parliamentary system. It is a pluralistic, multilingual and multi-ethnic society. India's population grew from 361 million in 1951 to 1 billion 211 million in 2011.[43] During the same time, its nominal per capita income, increased from $64 annually to $2,041, and its literacy rate from 16.6% to 74%. From being a comparatively destitute country in 1951,[44] India has become a fast-growing major economy, a hub for information technology services, with an expanding middle class.[45] It has a space program which includes several planned or completed lunar missions. Indian movies, music, and spiritual teachings play an increasing role in global culture.[46] India has substantially reduced its rate of poverty, though at the cost of increasing economic inequality.[47] India is a nuclear weapons state, which ranks high in military expenditure. It has disputes over Kashmir with its neighbors, Pakistan and China, unresolved since the mid-20th century.[48] Among the socioeconomic challenges India faces are gender inequality, child malnutrition,[49] and rising levels of air pollution.[50] India's land is megadiverse, with four biodiversity hotspots.[51] Its forest cover comprises 21.4% of its area.[52] India's wildlife, which has traditionally been viewed with tolerance in India's culture,[53] is supported among these forests, and elsewhere, in protected habitats."));
        countryDetailModels.add(new CountryDetailsModel("England", "England is a country that is part of the United Kingdom.[5][6][7] It shares land borders with Wales to the west and Scotland to the north. The Irish Sea lies west of England and the Celtic Sea to the southwest. England is separated from continental Europe by the North Sea to the east and the English Channel to the south. The country covers five-eighths of the island of Great Britain, which lies in the North Atlantic, and includes over 100 smaller islands, such as the Isles of Scilly and the Isle of Wight."));
        countryDetailModels.add(new CountryDetailsModel("France", "France (French: [fʁɑ̃s] (About this soundlisten)), officially the French Republic (French: République française, pronounced [ʁepyblik fʁɑ̃sɛːz] (About this soundlisten)), is a sovereign state whose territory consists of metropolitan France in Western Europe and several overseas regions and territories.[XIII] The metropolitan area of France extends from the Mediterranean Sea to the English Channel and the North Sea, and from the Rhine to the Atlantic Ocean. It is bordered by Belgium, Luxembourg and Germany to the northeast, Switzerland and Italy to the east, and Andorra and Spain to the south. The overseas territories include French Guiana in South America and several islands in the Atlantic, Pacific and Indian oceans. The country's 18 integral regions (five of which are situated overseas) span a combined area of 643,801 square kilometres (248,573 sq mi) and a total population of 67.02 million (as of July 2019).[10] France is a unitary semi-presidential republic with its capital in Paris, the country's largest city and main cultural and commercial centre. Other major urban areas include Lyon, Marseille, Toulouse, Bordeaux, Lille and Nice."));

        return countryDetailModels;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.desc);
    }

    protected CountryDetailsModel(Parcel in) {
        this.name = in.readString();
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<CountryDetailsModel> CREATOR = new Parcelable.Creator<CountryDetailsModel>() {
        @Override
        public CountryDetailsModel createFromParcel(Parcel source) {
            return new CountryDetailsModel(source);
        }

        @Override
        public CountryDetailsModel[] newArray(int size) {
            return new CountryDetailsModel[size];
        }
    };
}
