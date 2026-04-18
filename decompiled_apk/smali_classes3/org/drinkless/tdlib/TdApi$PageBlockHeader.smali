.class public Lorg/drinkless/tdlib/TdApi$PageBlockHeader;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockHeader"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x539ddd9b


# instance fields
.field public header:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17196
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17197
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17187
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17188
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockHeader;->header:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17189
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17193
    const v0, 0x539ddd9b

    return v0
.end method
