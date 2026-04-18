.class public Lorg/drinkless/tdlib/TdApi$UpdateReactionNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateReactionNotificationSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1ab2e814


# instance fields
.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22016
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22017
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;)V
    .locals 0
    .param p1, "reactionNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;

    .line 22007
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 22008
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateReactionNotificationSettings;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;

    .line 22009
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22013
    const v0, -0x1ab2e814

    return v0
.end method
