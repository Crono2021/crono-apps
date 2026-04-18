.class public Lorg/drinkless/tdlib/TdApi$NotificationSounds;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationSounds"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x259971f1


# instance fields
.field public notificationSounds:[Lorg/drinkless/tdlib/TdApi$NotificationSound;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16999
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$NotificationSound;)V
    .locals 0
    .param p1, "notificationSoundArr"    # [Lorg/drinkless/tdlib/TdApi$NotificationSound;

    .line 16989
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16990
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$NotificationSounds;->notificationSounds:[Lorg/drinkless/tdlib/TdApi$NotificationSound;

    .line 16991
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16995
    const v0, -0x259971f1

    return v0
.end method
