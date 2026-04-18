.class public Lorg/drinkless/tdlib/TdApi$PageBlockFooter;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockFooter"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x34d5d728


# instance fields
.field public footer:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17178
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17179
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17169
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17170
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockFooter;->footer:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 17171
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17175
    const v0, 0x34d5d728

    return v0
.end method
