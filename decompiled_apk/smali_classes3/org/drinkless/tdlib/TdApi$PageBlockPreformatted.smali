.class public Lorg/drinkless/tdlib/TdApi$PageBlockPreformatted;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockPreformatted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3f8f26c2


# instance fields
.field public language:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29085
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;Ljava/lang/String;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "str"    # Ljava/lang/String;

    .line 29074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 29075
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockPreformatted;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 29076
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PageBlockPreformatted;->language:Ljava/lang/String;

    .line 29077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29081
    const v0, -0x3f8f26c2

    return v0
.end method
