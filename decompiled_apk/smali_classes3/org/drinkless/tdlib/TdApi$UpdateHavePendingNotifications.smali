.class public Lorg/drinkless/tdlib/TdApi$UpdateHavePendingNotifications;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateHavePendingNotifications"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xaaee1db


# instance fields
.field public haveDelayedNotifications:Z

.field public haveUnreceivedNotifications:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34568
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34569
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 34558
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34559
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateHavePendingNotifications;->haveDelayedNotifications:Z

    .line 34560
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateHavePendingNotifications;->haveUnreceivedNotifications:Z

    .line 34561
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34565
    const v0, 0xaaee1db

    return v0
.end method
