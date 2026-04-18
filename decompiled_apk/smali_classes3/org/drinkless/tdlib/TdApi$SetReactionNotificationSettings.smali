.class public Lorg/drinkless/tdlib/TdApi$SetReactionNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetReactionNotificationSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x46b2d495


# instance fields
.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19896
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19897
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;)V
    .locals 0
    .param p1, "reactionNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;

    .line 19887
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19888
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetReactionNotificationSettings;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;

    .line 19889
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19893
    const v0, 0x46b2d495

    return v0
.end method
