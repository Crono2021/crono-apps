.class public Lorg/drinkless/tdlib/TdApi$WebApp;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WebApp"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x605ba8f3


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public description:Ljava/lang/String;

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public shortName:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49282
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49283
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;Lorg/drinkless/tdlib/TdApi$Animation;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p5, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;

    .line 49269
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49270
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$WebApp;->shortName:Ljava/lang/String;

    .line 49271
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$WebApp;->title:Ljava/lang/String;

    .line 49272
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$WebApp;->description:Ljava/lang/String;

    .line 49273
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$WebApp;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 49274
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$WebApp;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 49275
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49279
    const v0, 0x605ba8f3

    return v0
.end method
