.class public Lorg/drinkless/tdlib/TdApi$ReactionTypeEmoji;
.super Lorg/drinkless/tdlib/TdApi$ReactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReactionTypeEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x73c1dd38


# instance fields
.field public emoji:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReactionType;-><init>()V

    .line 18295
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 18285
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReactionType;-><init>()V

    .line 18286
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReactionTypeEmoji;->emoji:Ljava/lang/String;

    .line 18287
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18291
    const v0, -0x73c1dd38

    return v0
.end method
