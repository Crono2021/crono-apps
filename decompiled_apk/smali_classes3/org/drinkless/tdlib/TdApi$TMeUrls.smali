.class public Lorg/drinkless/tdlib/TdApi$TMeUrls;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TMeUrls"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4363831a


# instance fields
.field public urls:[Lorg/drinkless/tdlib/TdApi$TMeUrl;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20815
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$TMeUrl;)V
    .locals 0
    .param p1, "tMeUrlArr"    # [Lorg/drinkless/tdlib/TdApi$TMeUrl;

    .line 20805
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20806
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TMeUrls;->urls:[Lorg/drinkless/tdlib/TdApi$TMeUrl;

    .line 20807
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20811
    const v0, -0x4363831a

    return v0
.end method
