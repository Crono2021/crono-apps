.class public Lorg/drinkless/tdlib/TdApi$SetSavedMessagesTagLabel;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetSavedMessagesTagLabel"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4fc532f0


# instance fields
.field public label:Ljava/lang/String;

.field public tag:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31869
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;Ljava/lang/String;)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p2, "str"    # Ljava/lang/String;

    .line 31858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31859
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetSavedMessagesTagLabel;->tag:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 31860
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetSavedMessagesTagLabel;->label:Ljava/lang/String;

    .line 31861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31865
    const v0, -0x4fc532f0

    return v0
.end method
