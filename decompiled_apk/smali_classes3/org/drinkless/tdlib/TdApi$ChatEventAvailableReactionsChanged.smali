.class public Lorg/drinkless/tdlib/TdApi$ChatEventAvailableReactionsChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventAvailableReactionsChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x68471f41


# instance fields
.field public newAvailableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

.field public oldAvailableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23685
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;)V
    .locals 0
    .param p1, "chatAvailableReactions"    # Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;
    .param p2, "chatAvailableReactions2"    # Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

    .line 23674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23675
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventAvailableReactionsChanged;->oldAvailableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

    .line 23676
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventAvailableReactionsChanged;->newAvailableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

    .line 23677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23681
    const v0, -0x68471f41

    return v0
.end method
