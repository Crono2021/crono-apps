.class public Lorg/drinkless/tdlib/TdApi$Game;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Game"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5d512038


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public description:Ljava/lang/String;

.field public id:J

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public shortName:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51315
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;Lorg/drinkless/tdlib/TdApi$Animation;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p6, "str3"    # Ljava/lang/String;
    .param p7, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p8, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;

    .line 51299
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51300
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$Game;->id:J

    .line 51301
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Game;->shortName:Ljava/lang/String;

    .line 51302
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$Game;->title:Ljava/lang/String;

    .line 51303
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$Game;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 51304
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$Game;->description:Ljava/lang/String;

    .line 51305
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$Game;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 51306
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$Game;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 51307
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51311
    const v0, -0x5d512038

    return v0
.end method
