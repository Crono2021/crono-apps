.class public Lorg/drinkless/tdlib/TdApi$RemoveSavedNotificationSound;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveSavedNotificationSound"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1c9cb8b2


# instance fields
.field public notificationSoundId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18600
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18601
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 18591
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 18592
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveSavedNotificationSound;->notificationSoundId:J

    .line 18593
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18597
    const v0, -0x1c9cb8b2

    return v0
.end method
