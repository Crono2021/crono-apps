.class final Landroidx/media3/extractor/mp4/MetadataUtil;
.super Ljava/lang/Object;
.source "MetadataUtil.java"


# static fields
.field private static final PICTURE_TYPE_FRONT_COVER:I = 0x3

.field private static final SHORT_TYPE_ALBUM:I = 0x616c62

.field private static final SHORT_TYPE_ARTIST:I = 0x415254

.field private static final SHORT_TYPE_COMMENT:I = 0x636d74

.field private static final SHORT_TYPE_COMPOSER_1:I = 0x636f6d

.field private static final SHORT_TYPE_COMPOSER_2:I = 0x777274

.field private static final SHORT_TYPE_ENCODER:I = 0x746f6f

.field private static final SHORT_TYPE_GENRE:I = 0x67656e

.field private static final SHORT_TYPE_LYRICS:I = 0x6c7972

.field private static final SHORT_TYPE_NAME_1:I = 0x6e616d

.field private static final SHORT_TYPE_NAME_2:I = 0x74726b

.field private static final SHORT_TYPE_YEAR:I = 0x646179

.field static final STANDARD_GENRES:[Ljava/lang/String;

.field private static final TAG:Ljava/lang/String; = "MetadataUtil"

.field private static final TYPE_ALBUM_ARTIST:I = 0x61415254

.field private static final TYPE_COMPILATION:I = 0x6370696c

.field private static final TYPE_COVER_ART:I = 0x636f7672

.field private static final TYPE_DISK_NUMBER:I = 0x6469736b

.field private static final TYPE_GAPLESS_ALBUM:I = 0x70676170

.field private static final TYPE_GENRE:I = 0x676e7265

.field private static final TYPE_GROUPING:I = 0x677270

.field private static final TYPE_INTERNAL:I = 0x2d2d2d2d

.field private static final TYPE_RATING:I = 0x72746e67

.field private static final TYPE_SORT_ALBUM:I = 0x736f616c

.field private static final TYPE_SORT_ALBUM_ARTIST:I = 0x736f6161

.field private static final TYPE_SORT_ARTIST:I = 0x736f6172

.field private static final TYPE_SORT_COMPOSER:I = 0x736f636f

.field private static final TYPE_SORT_TRACK_NAME:I = 0x736f6e6d

.field private static final TYPE_TEMPO:I = 0x746d706f

.field private static final TYPE_TOP_BYTE_COPYRIGHT:I = 0xa9

.field private static final TYPE_TOP_BYTE_REPLACEMENT:I = 0xfd

.field private static final TYPE_TRACK_NUMBER:I = 0x74726b6e

.field private static final TYPE_TV_SHOW:I = 0x74767368

.field private static final TYPE_TV_SORT_SHOW:I = 0x736f736e


# direct methods
.method static constructor <clinit>()V
    .locals 192

    .line 83
    const-string v0, "Blues"

    const-string v1, "Classic Rock"

    const-string v2, "Country"

    const-string v3, "Dance"

    const-string v4, "Disco"

    const-string v5, "Funk"

    const-string v6, "Grunge"

    const-string v7, "Hip-Hop"

    const-string v8, "Jazz"

    const-string v9, "Metal"

    const-string v10, "New Age"

    const-string v11, "Oldies"

    const-string v12, "Other"

    const-string v13, "Pop"

    const-string v14, "R&B"

    const-string v15, "Rap"

    const-string v16, "Reggae"

    const-string v17, "Rock"

    const-string v18, "Techno"

    const-string v19, "Industrial"

    const-string v20, "Alternative"

    const-string v21, "Ska"

    const-string v22, "Death Metal"

    const-string v23, "Pranks"

    const-string v24, "Soundtrack"

    const-string v25, "Euro-Techno"

    const-string v26, "Ambient"

    const-string v27, "Trip-Hop"

    const-string v28, "Vocal"

    const-string v29, "Jazz+Funk"

    const-string v30, "Fusion"

    const-string v31, "Trance"

    const-string v32, "Classical"

    const-string v33, "Instrumental"

    const-string v34, "Acid"

    const-string v35, "House"

    const-string v36, "Game"

    const-string v37, "Sound Clip"

    const-string v38, "Gospel"

    const-string v39, "Noise"

    const-string v40, "AlternRock"

    const-string v41, "Bass"

    const-string v42, "Soul"

    const-string v43, "Punk"

    const-string v44, "Space"

    const-string v45, "Meditative"

    const-string v46, "Instrumental Pop"

    const-string v47, "Instrumental Rock"

    const-string v48, "Ethnic"

    const-string v49, "Gothic"

    const-string v50, "Darkwave"

    const-string v51, "Techno-Industrial"

    const-string v52, "Electronic"

    const-string v53, "Pop-Folk"

    const-string v54, "Eurodance"

    const-string v55, "Dream"

    const-string v56, "Southern Rock"

    const-string v57, "Comedy"

    const-string v58, "Cult"

    const-string v59, "Gangsta"

    const-string v60, "Top 40"

    const-string v61, "Christian Rap"

    const-string v62, "Pop/Funk"

    const-string v63, "Jungle"

    const-string v64, "Native American"

    const-string v65, "Cabaret"

    const-string v66, "New Wave"

    const-string v67, "Psychadelic"

    const-string v68, "Rave"

    const-string v69, "Showtunes"

    const-string v70, "Trailer"

    const-string v71, "Lo-Fi"

    const-string v72, "Tribal"

    const-string v73, "Acid Punk"

    const-string v74, "Acid Jazz"

    const-string v75, "Polka"

    const-string v76, "Retro"

    const-string v77, "Musical"

    const-string v78, "Rock & Roll"

    const-string v79, "Hard Rock"

    const-string v80, "Folk"

    const-string v81, "Folk-Rock"

    const-string v82, "National Folk"

    const-string v83, "Swing"

    const-string v84, "Fast Fusion"

    const-string v85, "Bebob"

    const-string v86, "Latin"

    const-string v87, "Revival"

    const-string v88, "Celtic"

    const-string v89, "Bluegrass"

    const-string v90, "Avantgarde"

    const-string v91, "Gothic Rock"

    const-string v92, "Progressive Rock"

    const-string v93, "Psychedelic Rock"

    const-string v94, "Symphonic Rock"

    const-string v95, "Slow Rock"

    const-string v96, "Big Band"

    const-string v97, "Chorus"

    const-string v98, "Easy Listening"

    const-string v99, "Acoustic"

    const-string v100, "Humour"

    const-string v101, "Speech"

    const-string v102, "Chanson"

    const-string v103, "Opera"

    const-string v104, "Chamber Music"

    const-string v105, "Sonata"

    const-string v106, "Symphony"

    const-string v107, "Booty Bass"

    const-string v108, "Primus"

    const-string v109, "Porn Groove"

    const-string v110, "Satire"

    const-string v111, "Slow Jam"

    const-string v112, "Club"

    const-string v113, "Tango"

    const-string v114, "Samba"

    const-string v115, "Folklore"

    const-string v116, "Ballad"

    const-string v117, "Power Ballad"

    const-string v118, "Rhythmic Soul"

    const-string v119, "Freestyle"

    const-string v120, "Duet"

    const-string v121, "Punk Rock"

    const-string v122, "Drum Solo"

    const-string v123, "A capella"

    const-string v124, "Euro-House"

    const-string v125, "Dance Hall"

    const-string v126, "Goa"

    const-string v127, "Drum & Bass"

    const-string v128, "Club-House"

    const-string v129, "Hardcore"

    const-string v130, "Terror"

    const-string v131, "Indie"

    const-string v132, "BritPop"

    const-string v133, "Afro-Punk"

    const-string v134, "Polsk Punk"

    const-string v135, "Beat"

    const-string v136, "Christian Gangsta Rap"

    const-string v137, "Heavy Metal"

    const-string v138, "Black Metal"

    const-string v139, "Crossover"

    const-string v140, "Contemporary Christian"

    const-string v141, "Christian Rock"

    const-string v142, "Merengue"

    const-string v143, "Salsa"

    const-string v144, "Thrash Metal"

    const-string v145, "Anime"

    const-string v146, "Jpop"

    const-string v147, "Synthpop"

    const-string v148, "Abstract"

    const-string v149, "Art Rock"

    const-string v150, "Baroque"

    const-string v151, "Bhangra"

    const-string v152, "Big beat"

    const-string v153, "Breakbeat"

    const-string v154, "Chillout"

    const-string v155, "Downtempo"

    const-string v156, "Dub"

    const-string v157, "EBM"

    const-string v158, "Eclectic"

    const-string v159, "Electro"

    const-string v160, "Electroclash"

    const-string v161, "Emo"

    const-string v162, "Experimental"

    const-string v163, "Garage"

    const-string v164, "Global"

    const-string v165, "IDM"

    const-string v166, "Illbient"

    const-string v167, "Industro-Goth"

    const-string v168, "Jam Band"

    const-string v169, "Krautrock"

    const-string v170, "Leftfield"

    const-string v171, "Lounge"

    const-string v172, "Math Rock"

    const-string v173, "New Romantic"

    const-string v174, "Nu-Breakz"

    const-string v175, "Post-Punk"

    const-string v176, "Post-Rock"

    const-string v177, "Psytrance"

    const-string v178, "Shoegaze"

    const-string v179, "Space Rock"

    const-string v180, "Trop Rock"

    const-string v181, "World Music"

    const-string v182, "Neoclassical"

    const-string v183, "Audiobook"

    const-string v184, "Audio theatre"

    const-string v185, "Neue Deutsche Welle"

    const-string v186, "Podcast"

    const-string v187, "Indie-Rock"

    const-string v188, "G-Funk"

    const-string v189, "Dubstep"

    const-string v190, "Garage Rock"

    const-string v191, "Psybient"

    filled-new-array/range {v0 .. v191}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/mp4/MetadataUtil;->STANDARD_GENRES:[Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 286
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static parseCommentAttribute(ILandroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/CommentFrame;
    .locals 5
    .param p0, "type"    # I
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 459
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 460
    .local v0, "atomSize":I
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 461
    .local v1, "atomType":I
    const v2, 0x64617461

    if-ne v1, v2, :cond_0

    .line 462
    const/16 v2, 0x8

    invoke-virtual {p1, v2}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 463
    add-int/lit8 v2, v0, -0x10

    invoke-virtual {p1, v2}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString(I)Ljava/lang/String;

    move-result-object v2

    .line 464
    .local v2, "value":Ljava/lang/String;
    new-instance v3, Landroidx/media3/extractor/metadata/id3/CommentFrame;

    const-string/jumbo v4, "und"

    invoke-direct {v3, v4, v2, v2}, Landroidx/media3/extractor/metadata/id3/CommentFrame;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v3

    .line 466
    .end local v2    # "value":Ljava/lang/String;
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to parse comment attribute: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p0}, Landroidx/media3/extractor/mp4/Atom;->getAtomTypeString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "MetadataUtil"

    invoke-static {v3, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 467
    const/4 v2, 0x0

    return-object v2
.end method

.method private static parseCoverArt(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/ApicFrame;
    .locals 9
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 531
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 532
    .local v0, "atomSize":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 533
    .local v1, "atomType":I
    const v2, 0x64617461

    const-string v3, "MetadataUtil"

    const/4 v4, 0x0

    if-ne v1, v2, :cond_3

    .line 534
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 535
    .local v2, "fullVersionInt":I
    invoke-static {v2}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomFlags(I)I

    move-result v5

    .line 536
    .local v5, "flags":I
    const/16 v6, 0xd

    if-ne v5, v6, :cond_0

    const-string v6, "image/jpeg"

    goto :goto_0

    :cond_0
    const/16 v6, 0xe

    if-ne v5, v6, :cond_1

    const-string v6, "image/png"

    goto :goto_0

    :cond_1
    move-object v6, v4

    .line 537
    .local v6, "mimeType":Ljava/lang/String;
    :goto_0
    if-nez v6, :cond_2

    .line 538
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unrecognized cover art flags: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v3, v7}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 539
    return-object v4

    .line 541
    :cond_2
    const/4 v3, 0x4

    invoke-virtual {p0, v3}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 542
    add-int/lit8 v3, v0, -0x10

    new-array v3, v3, [B

    .line 543
    .local v3, "pictureData":[B
    const/4 v7, 0x0

    array-length v8, v3

    invoke-virtual {p0, v3, v7, v8}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 544
    new-instance v7, Landroidx/media3/extractor/metadata/id3/ApicFrame;

    const/4 v8, 0x3

    invoke-direct {v7, v6, v4, v8, v3}, Landroidx/media3/extractor/metadata/id3/ApicFrame;-><init>(Ljava/lang/String;Ljava/lang/String;I[B)V

    return-object v7

    .line 550
    .end local v2    # "fullVersionInt":I
    .end local v3    # "pictureData":[B
    .end local v5    # "flags":I
    .end local v6    # "mimeType":Ljava/lang/String;
    :cond_3
    const-string v2, "Failed to parse cover art attribute"

    invoke-static {v3, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 551
    return-object v4
.end method

.method public static parseIlstElement(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/common/Metadata$Entry;
    .locals 7
    .param p0, "ilst"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 345
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    .line 346
    .local v0, "position":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    add-int/2addr v1, v0

    .line 347
    .local v1, "endPosition":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 348
    .local v2, "type":I
    shr-int/lit8 v3, v2, 0x18

    and-int/lit16 v3, v3, 0xff

    .line 350
    .local v3, "typeTopByte":I
    const/16 v4, 0xa9

    if-eq v3, v4, :cond_11

    const/16 v4, 0xfd

    if-ne v3, v4, :cond_0

    goto/16 :goto_0

    .line 373
    :cond_0
    const v4, 0x676e7265

    if-ne v2, v4, :cond_1

    .line 374
    :try_start_0
    invoke-static {p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseStandardGenreAttribute(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 374
    return-object v4

    .line 375
    :cond_1
    const v4, 0x6469736b

    if-ne v2, v4, :cond_2

    .line 376
    :try_start_1
    const-string v4, "TPOS"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseIndexAndCountAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 376
    return-object v4

    .line 377
    :cond_2
    const v4, 0x74726b6e

    if-ne v2, v4, :cond_3

    .line 378
    :try_start_2
    const-string v4, "TRCK"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseIndexAndCountAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 378
    return-object v4

    .line 379
    :cond_3
    const v4, 0x746d706f

    const/4 v5, 0x0

    const/4 v6, 0x1

    if-ne v2, v4, :cond_4

    .line 380
    :try_start_3
    const-string v4, "TBPM"

    invoke-static {v2, v4, p0, v6, v5}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseUint8Attribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;ZZ)Landroidx/media3/extractor/metadata/id3/Id3Frame;

    move-result-object v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 380
    return-object v4

    .line 381
    :cond_4
    const v4, 0x6370696c

    if-ne v2, v4, :cond_5

    .line 382
    :try_start_4
    const-string v4, "TCMP"

    invoke-static {v2, v4, p0, v6, v6}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseUint8Attribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;ZZ)Landroidx/media3/extractor/metadata/id3/Id3Frame;

    move-result-object v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 382
    return-object v4

    .line 383
    :cond_5
    const v4, 0x636f7672

    if-ne v2, v4, :cond_6

    .line 384
    :try_start_5
    invoke-static {p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseCoverArt(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/ApicFrame;

    move-result-object v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 384
    return-object v4

    .line 385
    :cond_6
    const v4, 0x61415254

    if-ne v2, v4, :cond_7

    .line 386
    :try_start_6
    const-string v4, "TPE2"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 386
    return-object v4

    .line 387
    :cond_7
    const v4, 0x736f6e6d

    if-ne v2, v4, :cond_8

    .line 388
    :try_start_7
    const-string v4, "TSOT"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 388
    return-object v4

    .line 389
    :cond_8
    const v4, 0x736f616c

    if-ne v2, v4, :cond_9

    .line 390
    :try_start_8
    const-string v4, "TSO2"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 390
    return-object v4

    .line 391
    :cond_9
    const v4, 0x736f6172

    if-ne v2, v4, :cond_a

    .line 392
    :try_start_9
    const-string v4, "TSOA"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 392
    return-object v4

    .line 393
    :cond_a
    const v4, 0x736f6161

    if-ne v2, v4, :cond_b

    .line 394
    :try_start_a
    const-string v4, "TSOP"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 394
    return-object v4

    .line 395
    :cond_b
    const v4, 0x736f636f

    if-ne v2, v4, :cond_c

    .line 396
    :try_start_b
    const-string v4, "TSOC"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 396
    return-object v4

    .line 397
    :cond_c
    const v4, 0x72746e67

    if-ne v2, v4, :cond_d

    .line 398
    :try_start_c
    const-string v4, "ITUNESADVISORY"

    invoke-static {v2, v4, p0, v5, v5}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseUint8Attribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;ZZ)Landroidx/media3/extractor/metadata/id3/Id3Frame;

    move-result-object v4
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 398
    return-object v4

    .line 399
    :cond_d
    const v4, 0x70676170

    if-ne v2, v4, :cond_e

    .line 400
    :try_start_d
    const-string v4, "ITUNESGAPLESS"

    invoke-static {v2, v4, p0, v5, v6}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseUint8Attribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;ZZ)Landroidx/media3/extractor/metadata/id3/Id3Frame;

    move-result-object v4
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 400
    return-object v4

    .line 401
    :cond_e
    const v4, 0x736f736e

    if-ne v2, v4, :cond_f

    .line 402
    :try_start_e
    const-string v4, "TVSHOWSORT"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 402
    return-object v4

    .line 403
    :cond_f
    const v4, 0x74767368

    if-ne v2, v4, :cond_10

    .line 404
    :try_start_f
    const-string v4, "TVSHOW"

    invoke-static {v2, v4, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v4
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 404
    return-object v4

    .line 405
    :cond_10
    const v4, 0x2d2d2d2d

    if-ne v2, v4, :cond_1c

    .line 406
    :try_start_10
    invoke-static {p0, v1}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseInternalAttribute(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/extractor/metadata/id3/Id3Frame;

    move-result-object v4
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 406
    return-object v4

    .line 351
    :cond_11
    :goto_0
    const v4, 0xffffff

    and-int/2addr v4, v2

    .line 352
    .local v4, "shortType":I
    const v5, 0x636d74

    if-ne v4, v5, :cond_12

    .line 353
    :try_start_11
    invoke-static {v2, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseCommentAttribute(ILandroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/CommentFrame;

    move-result-object v5
    :try_end_11
    .catchall {:try_start_11 .. :try_end_11} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 353
    return-object v5

    .line 411
    .end local v4    # "shortType":I
    :catchall_0
    move-exception v4

    goto/16 :goto_3

    .line 354
    .restart local v4    # "shortType":I
    :cond_12
    const v5, 0x6e616d

    if-eq v4, v5, :cond_1e

    const v5, 0x74726b

    if-ne v4, v5, :cond_13

    goto/16 :goto_2

    .line 356
    :cond_13
    const v5, 0x636f6d

    if-eq v4, v5, :cond_1d

    const v5, 0x777274

    if-ne v4, v5, :cond_14

    goto/16 :goto_1

    .line 358
    :cond_14
    const v5, 0x646179

    if-ne v4, v5, :cond_15

    .line 359
    :try_start_12
    const-string v5, "TDRC"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_12
    .catchall {:try_start_12 .. :try_end_12} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 359
    return-object v5

    .line 360
    :cond_15
    const v5, 0x415254

    if-ne v4, v5, :cond_16

    .line 361
    :try_start_13
    const-string v5, "TPE1"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_13
    .catchall {:try_start_13 .. :try_end_13} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 361
    return-object v5

    .line 362
    :cond_16
    const v5, 0x746f6f

    if-ne v4, v5, :cond_17

    .line 363
    :try_start_14
    const-string v5, "TSSE"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_14
    .catchall {:try_start_14 .. :try_end_14} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 363
    return-object v5

    .line 364
    :cond_17
    const v5, 0x616c62

    if-ne v4, v5, :cond_18

    .line 365
    :try_start_15
    const-string v5, "TALB"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_15
    .catchall {:try_start_15 .. :try_end_15} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 365
    return-object v5

    .line 366
    :cond_18
    const v5, 0x6c7972

    if-ne v4, v5, :cond_19

    .line 367
    :try_start_16
    const-string v5, "USLT"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_16
    .catchall {:try_start_16 .. :try_end_16} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 367
    return-object v5

    .line 368
    :cond_19
    const v5, 0x67656e

    if-ne v4, v5, :cond_1a

    .line 369
    :try_start_17
    const-string v5, "TCON"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_17
    .catchall {:try_start_17 .. :try_end_17} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 369
    return-object v5

    .line 370
    :cond_1a
    const v5, 0x677270

    if-ne v4, v5, :cond_1b

    .line 371
    :try_start_18
    const-string v5, "TIT1"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_18
    .catchall {:try_start_18 .. :try_end_18} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 371
    return-object v5

    .line 373
    .end local v4    # "shortType":I
    :cond_1b
    nop

    .line 408
    :cond_1c
    :try_start_19
    const-string v4, "MetadataUtil"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Skipped unknown metadata entry: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v2}, Landroidx/media3/extractor/mp4/Atom;->getAtomTypeString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroidx/media3/common/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_19
    .catchall {:try_start_19 .. :try_end_19} :catchall_0

    .line 409
    nop

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 409
    const/4 v4, 0x0

    return-object v4

    .line 357
    .restart local v4    # "shortType":I
    :cond_1d
    :goto_1
    :try_start_1a
    const-string v5, "TCOM"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_1a
    .catchall {:try_start_1a .. :try_end_1a} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 357
    return-object v5

    .line 355
    :cond_1e
    :goto_2
    :try_start_1b
    const-string v5, "TIT2"

    invoke-static {v2, v5, p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    move-result-object v5
    :try_end_1b
    .catchall {:try_start_1b .. :try_end_1b} :catchall_0

    .line 411
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 355
    return-object v5

    .line 411
    .end local v4    # "shortType":I
    :goto_3
    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 412
    throw v4
.end method

.method private static parseIndexAndCountAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;
    .locals 8
    .param p0, "type"    # I
    .param p1, "attributeName"    # Ljava/lang/String;
    .param p2, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 494
    invoke-virtual {p2}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 495
    .local v0, "atomSize":I
    invoke-virtual {p2}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 496
    .local v1, "atomType":I
    const v2, 0x64617461

    const/4 v3, 0x0

    if-ne v1, v2, :cond_1

    const/16 v2, 0x16

    if-lt v0, v2, :cond_1

    .line 497
    const/16 v2, 0xa

    invoke-virtual {p2, v2}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 498
    invoke-virtual {p2}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v2

    .line 499
    .local v2, "index":I
    if-lez v2, :cond_1

    .line 500
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 501
    .local v4, "value":Ljava/lang/String;
    invoke-virtual {p2}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v5

    .line 502
    .local v5, "count":I
    if-lez v5, :cond_0

    .line 503
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 505
    :cond_0
    new-instance v6, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    .line 506
    invoke-static {v4}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v7

    invoke-direct {v6, p1, v3, v7}, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 505
    return-object v6

    .line 509
    .end local v2    # "index":I
    .end local v4    # "value":Ljava/lang/String;
    .end local v5    # "count":I
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to parse index/count attribute: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p0}, Landroidx/media3/extractor/mp4/Atom;->getAtomTypeString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v4, "MetadataUtil"

    invoke-static {v4, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 510
    return-object v3
.end method

.method private static parseInternalAttribute(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/extractor/metadata/id3/Id3Frame;
    .locals 8
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "endPosition"    # I

    .line 556
    const/4 v0, 0x0

    .line 557
    .local v0, "domain":Ljava/lang/String;
    const/4 v1, 0x0

    .line 558
    .local v1, "name":Ljava/lang/String;
    const/4 v2, -0x1

    .line 559
    .local v2, "dataAtomPosition":I
    const/4 v3, -0x1

    .line 560
    .local v3, "dataAtomSize":I
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v4

    if-ge v4, p1, :cond_3

    .line 561
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v4

    .line 562
    .local v4, "atomPosition":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 563
    .local v5, "atomSize":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v6

    .line 564
    .local v6, "atomType":I
    const/4 v7, 0x4

    invoke-virtual {p0, v7}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 565
    const v7, 0x6d65616e

    if-ne v6, v7, :cond_0

    .line 566
    add-int/lit8 v7, v5, -0xc

    invoke-virtual {p0, v7}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 567
    :cond_0
    const v7, 0x6e616d65

    if-ne v6, v7, :cond_1

    .line 568
    add-int/lit8 v7, v5, -0xc

    invoke-virtual {p0, v7}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 570
    :cond_1
    const v7, 0x64617461

    if-ne v6, v7, :cond_2

    .line 571
    move v2, v4

    .line 572
    move v3, v5

    .line 574
    :cond_2
    add-int/lit8 v7, v5, -0xc

    invoke-virtual {p0, v7}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 576
    .end local v4    # "atomPosition":I
    .end local v5    # "atomSize":I
    .end local v6    # "atomType":I
    :goto_1
    goto :goto_0

    .line 577
    :cond_3
    if-eqz v0, :cond_5

    if-eqz v1, :cond_5

    const/4 v4, -0x1

    if-ne v2, v4, :cond_4

    goto :goto_2

    .line 580
    :cond_4
    invoke-virtual {p0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 581
    const/16 v4, 0x10

    invoke-virtual {p0, v4}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 582
    add-int/lit8 v4, v3, -0x10

    invoke-virtual {p0, v4}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString(I)Ljava/lang/String;

    move-result-object v4

    .line 583
    .local v4, "value":Ljava/lang/String;
    new-instance v5, Landroidx/media3/extractor/metadata/id3/InternalFrame;

    invoke-direct {v5, v0, v1, v4}, Landroidx/media3/extractor/metadata/id3/InternalFrame;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v5

    .line 578
    .end local v4    # "value":Ljava/lang/String;
    :cond_5
    :goto_2
    const/4 v4, 0x0

    return-object v4
.end method

.method public static parseMdtaMetadataEntryFromIlst(Landroidx/media3/common/util/ParsableByteArray;ILjava/lang/String;)Landroidx/media3/container/MdtaMetadataEntry;
    .locals 8
    .param p0, "ilst"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "endPosition"    # I
    .param p2, "key"    # Ljava/lang/String;

    .line 427
    nop

    :goto_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    move v1, v0

    .local v1, "atomPosition":I
    if-ge v0, p1, :cond_1

    .line 428
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 429
    .local v0, "atomSize":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 430
    .local v2, "atomType":I
    const v3, 0x64617461

    if-ne v2, v3, :cond_0

    .line 431
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v3

    .line 432
    .local v3, "typeIndicator":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    .line 433
    .local v4, "localeIndicator":I
    add-int/lit8 v5, v0, -0x10

    .line 434
    .local v5, "dataSize":I
    new-array v6, v5, [B

    .line 435
    .local v6, "value":[B
    const/4 v7, 0x0

    invoke-virtual {p0, v6, v7, v5}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 436
    new-instance v7, Landroidx/media3/container/MdtaMetadataEntry;

    invoke-direct {v7, p2, v6, v4, v3}, Landroidx/media3/container/MdtaMetadataEntry;-><init>(Ljava/lang/String;[BII)V

    return-object v7

    .line 438
    .end local v3    # "typeIndicator":I
    .end local v4    # "localeIndicator":I
    .end local v5    # "dataSize":I
    .end local v6    # "value":[B
    :cond_0
    add-int v3, v1, v0

    invoke-virtual {p0, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 439
    .end local v0    # "atomSize":I
    .end local v2    # "atomType":I
    goto :goto_0

    .line 440
    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method private static parseStandardGenreAttribute(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;
    .locals 6
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 515
    invoke-static {p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseUint8AttributeValue(Landroidx/media3/common/util/ParsableByteArray;)I

    move-result v0

    .line 518
    .local v0, "genreCode":I
    const/4 v1, 0x0

    if-lez v0, :cond_0

    sget-object v2, Landroidx/media3/extractor/mp4/MetadataUtil;->STANDARD_GENRES:[Ljava/lang/String;

    array-length v3, v2

    if-gt v0, v3, :cond_0

    .line 519
    add-int/lit8 v3, v0, -0x1

    aget-object v2, v2, v3

    goto :goto_0

    .line 520
    :cond_0
    move-object v2, v1

    :goto_0
    nop

    .line 521
    .local v2, "genreString":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 522
    new-instance v3, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    .line 523
    invoke-static {v2}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v4

    const-string v5, "TCON"

    invoke-direct {v3, v5, v1, v4}, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 522
    return-object v3

    .line 525
    :cond_1
    const-string v3, "MetadataUtil"

    const-string v4, "Failed to parse standard genre code"

    invoke-static {v3, v4}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 526
    return-object v1
.end method

.method private static parseTextAttribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/metadata/id3/TextInformationFrame;
    .locals 6
    .param p0, "type"    # I
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 446
    invoke-virtual {p2}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 447
    .local v0, "atomSize":I
    invoke-virtual {p2}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 448
    .local v1, "atomType":I
    const v2, 0x64617461

    const/4 v3, 0x0

    if-ne v1, v2, :cond_0

    .line 449
    const/16 v2, 0x8

    invoke-virtual {p2, v2}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 450
    add-int/lit8 v2, v0, -0x10

    invoke-virtual {p2, v2}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString(I)Ljava/lang/String;

    move-result-object v2

    .line 451
    .local v2, "value":Ljava/lang/String;
    new-instance v4, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    invoke-static {v2}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    invoke-direct {v4, p1, v3, v5}, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    return-object v4

    .line 453
    .end local v2    # "value":Ljava/lang/String;
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to parse text attribute: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p0}, Landroidx/media3/extractor/mp4/Atom;->getAtomTypeString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v4, "MetadataUtil"

    invoke-static {v4, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 454
    return-object v3
.end method

.method private static parseUint8Attribute(ILjava/lang/String;Landroidx/media3/common/util/ParsableByteArray;ZZ)Landroidx/media3/extractor/metadata/id3/Id3Frame;
    .locals 4
    .param p0, "type"    # I
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p3, "isTextInformationFrame"    # Z
    .param p4, "isBoolean"    # Z

    .line 477
    invoke-static {p2}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseUint8AttributeValue(Landroidx/media3/common/util/ParsableByteArray;)I

    move-result v0

    .line 478
    .local v0, "value":I
    if-eqz p4, :cond_0

    .line 479
    const/4 v1, 0x1

    invoke-static {v1, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 481
    :cond_0
    const/4 v1, 0x0

    if-ltz v0, :cond_2

    .line 482
    if-eqz p3, :cond_1

    .line 483
    new-instance v2, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    .line 484
    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v3

    invoke-direct {v2, p1, v1, v3}, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    goto :goto_0

    .line 485
    :cond_1
    new-instance v2, Landroidx/media3/extractor/metadata/id3/CommentFrame;

    const-string/jumbo v1, "und"

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v1, p1, v3}, Landroidx/media3/extractor/metadata/id3/CommentFrame;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 482
    :goto_0
    return-object v2

    .line 487
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to parse uint8 attribute: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p0}, Landroidx/media3/extractor/mp4/Atom;->getAtomTypeString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "MetadataUtil"

    invoke-static {v3, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 488
    return-object v1
.end method

.method private static parseUint8AttributeValue(Landroidx/media3/common/util/ParsableByteArray;)I
    .locals 3
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 587
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 588
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 589
    .local v0, "atomType":I
    const v1, 0x64617461

    if-ne v0, v1, :cond_0

    .line 590
    const/16 v1, 0x8

    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 591
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v1

    return v1

    .line 593
    :cond_0
    const-string v1, "MetadataUtil"

    const-string v2, "Failed to parse uint8 attribute value"

    invoke-static {v1, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 594
    const/4 v1, -0x1

    return v1
.end method

.method public static setFormatGaplessInfo(ILandroidx/media3/extractor/GaplessInfoHolder;Landroidx/media3/common/Format$Builder;)V
    .locals 2
    .param p0, "trackType"    # I
    .param p1, "gaplessInfoHolder"    # Landroidx/media3/extractor/GaplessInfoHolder;
    .param p2, "formatBuilder"    # Landroidx/media3/common/Format$Builder;

    .line 327
    const/4 v0, 0x1

    if-ne p0, v0, :cond_0

    invoke-virtual {p1}, Landroidx/media3/extractor/GaplessInfoHolder;->hasGaplessInfo()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 328
    iget v0, p1, Landroidx/media3/extractor/GaplessInfoHolder;->encoderDelay:I

    .line 329
    invoke-virtual {p2, v0}, Landroidx/media3/common/Format$Builder;->setEncoderDelay(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    iget v1, p1, Landroidx/media3/extractor/GaplessInfoHolder;->encoderPadding:I

    .line 330
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setEncoderPadding(I)Landroidx/media3/common/Format$Builder;

    .line 332
    :cond_0
    return-void
.end method

.method public static varargs setFormatMetadata(ILandroidx/media3/common/Metadata;Landroidx/media3/common/Format$Builder;[Landroidx/media3/common/Metadata;)V
    .locals 7
    .param p0, "trackType"    # I
    .param p1, "mdtaMetadata"    # Landroidx/media3/common/Metadata;
    .param p2, "formatBuilder"    # Landroidx/media3/common/Format$Builder;
    .param p3, "additionalMetadata"    # [Landroidx/media3/common/Metadata;

    .line 294
    new-instance v0, Landroidx/media3/common/Metadata;

    const/4 v1, 0x0

    new-array v2, v1, [Landroidx/media3/common/Metadata$Entry;

    invoke-direct {v0, v2}, Landroidx/media3/common/Metadata;-><init>([Landroidx/media3/common/Metadata$Entry;)V

    .line 296
    .local v0, "formatMetadata":Landroidx/media3/common/Metadata;
    if-eqz p1, :cond_2

    .line 297
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p1}, Landroidx/media3/common/Metadata;->length()I

    move-result v3

    if-ge v2, v3, :cond_2

    .line 298
    invoke-virtual {p1, v2}, Landroidx/media3/common/Metadata;->get(I)Landroidx/media3/common/Metadata$Entry;

    move-result-object v3

    .line 299
    .local v3, "entry":Landroidx/media3/common/Metadata$Entry;
    instance-of v4, v3, Landroidx/media3/container/MdtaMetadataEntry;

    if-eqz v4, :cond_1

    .line 300
    move-object v4, v3

    check-cast v4, Landroidx/media3/container/MdtaMetadataEntry;

    .line 302
    .local v4, "mdtaMetadataEntry":Landroidx/media3/container/MdtaMetadataEntry;
    iget-object v5, v4, Landroidx/media3/container/MdtaMetadataEntry;->key:Ljava/lang/String;

    const-string v6, "com.android.capture.fps"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    const/4 v6, 0x1

    if-eqz v5, :cond_0

    .line 303
    const/4 v5, 0x2

    if-ne p0, v5, :cond_1

    .line 304
    new-array v5, v6, [Landroidx/media3/common/Metadata$Entry;

    aput-object v4, v5, v1

    invoke-virtual {v0, v5}, Landroidx/media3/common/Metadata;->copyWithAppendedEntries([Landroidx/media3/common/Metadata$Entry;)Landroidx/media3/common/Metadata;

    move-result-object v0

    goto :goto_1

    .line 307
    :cond_0
    new-array v5, v6, [Landroidx/media3/common/Metadata$Entry;

    aput-object v4, v5, v1

    invoke-virtual {v0, v5}, Landroidx/media3/common/Metadata;->copyWithAppendedEntries([Landroidx/media3/common/Metadata$Entry;)Landroidx/media3/common/Metadata;

    move-result-object v0

    .line 297
    .end local v3    # "entry":Landroidx/media3/common/Metadata$Entry;
    .end local v4    # "mdtaMetadataEntry":Landroidx/media3/container/MdtaMetadataEntry;
    :cond_1
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 313
    .end local v2    # "i":I
    :cond_2
    array-length v2, p3

    :goto_2
    if-ge v1, v2, :cond_3

    aget-object v3, p3, v1

    .line 314
    .local v3, "metadata":Landroidx/media3/common/Metadata;
    invoke-virtual {v0, v3}, Landroidx/media3/common/Metadata;->copyWithAppendedEntriesFrom(Landroidx/media3/common/Metadata;)Landroidx/media3/common/Metadata;

    move-result-object v0

    .line 313
    .end local v3    # "metadata":Landroidx/media3/common/Metadata;
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 317
    :cond_3
    invoke-virtual {v0}, Landroidx/media3/common/Metadata;->length()I

    move-result v1

    if-lez v1, :cond_4

    .line 318
    invoke-virtual {p2, v0}, Landroidx/media3/common/Format$Builder;->setMetadata(Landroidx/media3/common/Metadata;)Landroidx/media3/common/Format$Builder;

    .line 320
    :cond_4
    return-void
.end method
