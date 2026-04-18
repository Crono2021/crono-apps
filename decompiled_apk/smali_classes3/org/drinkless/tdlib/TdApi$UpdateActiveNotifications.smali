.class public Lorg/drinkless/tdlib/TdApi$UpdateActiveNotifications;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateActiveNotifications"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4de23c5d


# instance fields
.field public groups:[Lorg/drinkless/tdlib/TdApi$NotificationGroup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21494
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21495
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$NotificationGroup;)V
    .locals 0
    .param p1, "notificationGroupArr"    # [Lorg/drinkless/tdlib/TdApi$NotificationGroup;

    .line 21485
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21486
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateActiveNotifications;->groups:[Lorg/drinkless/tdlib/TdApi$NotificationGroup;

    .line 21487
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21491
    const v0, -0x4de23c5d

    return v0
.end method
