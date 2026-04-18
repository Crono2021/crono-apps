.class public Lorg/drinkless/tdlib/TdApi$UpdateSavedNotificationSounds;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSavedNotificationSounds"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3ebf51c2


# instance fields
.field public notificationSoundIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22088
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22089
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 22079
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22080
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateSavedNotificationSounds;->notificationSoundIds:[J

    .line 22081
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22085
    const v0, 0x3ebf51c2

    return v0
.end method
