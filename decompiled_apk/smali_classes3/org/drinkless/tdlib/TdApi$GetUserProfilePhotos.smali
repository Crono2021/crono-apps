.class public Lorg/drinkless/tdlib/TdApi$GetUserProfilePhotos;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetUserProfilePhotos"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatPhotos;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x362101be


# instance fields
.field public limit:I

.field public offset:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37644
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37645
    return-void
.end method

.method public constructor <init>(JII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I

    .line 37633
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37634
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetUserProfilePhotos;->userId:J

    .line 37635
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetUserProfilePhotos;->offset:I

    .line 37636
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetUserProfilePhotos;->limit:I

    .line 37637
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37641
    const v0, -0x362101be

    return v0
.end method
