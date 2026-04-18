.class public Lorg/drinkless/tdlib/TdApi$GetSavedNotificationSound;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetSavedNotificationSound"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$NotificationSounds;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1b647917


# instance fields
.field public notificationSoundId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13525
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13515
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13516
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetSavedNotificationSound;->notificationSoundId:J

    .line 13517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13521
    const v0, 0x1b647917

    return v0
.end method
