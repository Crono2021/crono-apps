.class public Lorg/drinkless/tdlib/TdApi$InputBusinessStartPage;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputBusinessStartPage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x13837820


# instance fields
.field public message:Ljava/lang/String;

.field public sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37908
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37909
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InputFile;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 37897
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37898
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputBusinessStartPage;->title:Ljava/lang/String;

    .line 37899
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputBusinessStartPage;->message:Ljava/lang/String;

    .line 37900
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputBusinessStartPage;->sticker:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 37901
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37905
    const v0, -0x13837820

    return v0
.end method
