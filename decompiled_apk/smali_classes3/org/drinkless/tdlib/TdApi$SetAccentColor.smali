.class public Lorg/drinkless/tdlib/TdApi$SetAccentColor;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetAccentColor"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6389cb39


# instance fields
.field public accentColorId:I

.field public backgroundCustomEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30928
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30929
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J

    .line 30918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30919
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetAccentColor;->accentColorId:I

    .line 30920
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SetAccentColor;->backgroundCustomEmojiId:J

    .line 30921
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30925
    const v0, 0x6389cb39

    return v0
.end method
