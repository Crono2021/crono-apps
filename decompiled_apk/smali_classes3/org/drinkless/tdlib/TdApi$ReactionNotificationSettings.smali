.class public Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReactionNotificationSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2bb0f654


# instance fields
.field public messageReactionSource:Lorg/drinkless/tdlib/TdApi$ReactionNotificationSource;

.field public showPreview:Z

.field public soundId:J

.field public storyReactionSource:Lorg/drinkless/tdlib/TdApi$ReactionNotificationSource;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44815
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionNotificationSource;Lorg/drinkless/tdlib/TdApi$ReactionNotificationSource;JZ)V
    .locals 0
    .param p1, "reactionNotificationSource"    # Lorg/drinkless/tdlib/TdApi$ReactionNotificationSource;
    .param p2, "reactionNotificationSource2"    # Lorg/drinkless/tdlib/TdApi$ReactionNotificationSource;
    .param p3, "j5"    # J
    .param p5, "z8"    # Z

    .line 44802
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44803
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;->messageReactionSource:Lorg/drinkless/tdlib/TdApi$ReactionNotificationSource;

    .line 44804
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;->storyReactionSource:Lorg/drinkless/tdlib/TdApi$ReactionNotificationSource;

    .line 44805
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;->soundId:J

    .line 44806
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ReactionNotificationSettings;->showPreview:Z

    .line 44807
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44811
    const v0, 0x2bb0f654

    return v0
.end method
