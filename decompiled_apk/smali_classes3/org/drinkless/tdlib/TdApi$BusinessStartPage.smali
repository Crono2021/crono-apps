.class public Lorg/drinkless/tdlib/TdApi$BusinessStartPage;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessStartPage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x605d0831


# instance fields
.field public message:Ljava/lang/String;

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35905
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 35893
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35894
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessStartPage;->title:Ljava/lang/String;

    .line 35895
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessStartPage;->message:Ljava/lang/String;

    .line 35896
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessStartPage;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 35897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35901
    const v0, -0x605d0831

    return v0
.end method
