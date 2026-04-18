.class public Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisements;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VideoMessageAdvertisements"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x69e14229


# instance fields
.field public advertisements:[Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;

.field public betweenDelay:I

.field public startDelay:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42154
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42155
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;II)V
    .locals 0
    .param p1, "videoMessageAdvertisementArr"    # [Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;
    .param p2, "i9"    # I
    .param p3, "i10"    # I

    .line 42143
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42144
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisements;->advertisements:[Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisement;

    .line 42145
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisements;->startDelay:I

    .line 42146
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$VideoMessageAdvertisements;->betweenDelay:I

    .line 42147
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42151
    const v0, -0x69e14229

    return v0
.end method
