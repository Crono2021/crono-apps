.class public Lorg/drinkless/tdlib/TdApi$PageBlockKicker;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockKicker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5123864b


# instance fields
.field public kicker:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17214
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17215
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17205
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17206
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockKicker;->kicker:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17207
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17211
    const v0, 0x5123864b

    return v0
.end method
