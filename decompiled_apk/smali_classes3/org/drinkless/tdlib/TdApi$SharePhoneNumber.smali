.class public Lorg/drinkless/tdlib/TdApi$SharePhoneNumber;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SharePhoneNumber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4164e055


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19968
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19969
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 19959
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19960
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SharePhoneNumber;->userId:J

    .line 19961
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19965
    const v0, 0x4164e055

    return v0
.end method
