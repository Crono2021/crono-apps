.class public Lorg/drinkless/tdlib/TdApi$ChatEventBackgroundChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventBackgroundChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x491292c8


# instance fields
.field public newBackground:Lorg/drinkless/tdlib/TdApi$ChatBackground;

.field public oldBackground:Lorg/drinkless/tdlib/TdApi$ChatBackground;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23704
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23705
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatBackground;Lorg/drinkless/tdlib/TdApi$ChatBackground;)V
    .locals 0
    .param p1, "chatBackground"    # Lorg/drinkless/tdlib/TdApi$ChatBackground;
    .param p2, "chatBackground2"    # Lorg/drinkless/tdlib/TdApi$ChatBackground;

    .line 23694
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23695
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventBackgroundChanged;->oldBackground:Lorg/drinkless/tdlib/TdApi$ChatBackground;

    .line 23696
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventBackgroundChanged;->newBackground:Lorg/drinkless/tdlib/TdApi$ChatBackground;

    .line 23697
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23701
    const v0, -0x491292c8

    return v0
.end method
