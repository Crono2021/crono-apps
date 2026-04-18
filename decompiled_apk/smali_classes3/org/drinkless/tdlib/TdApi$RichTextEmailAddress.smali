.class public Lorg/drinkless/tdlib/TdApi$RichTextEmailAddress;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextEmailAddress"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x262a2f7


# instance fields
.field public emailAddress:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30428
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 30429
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;Ljava/lang/String;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "str"    # Ljava/lang/String;

    .line 30418
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 30419
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextEmailAddress;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 30420
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RichTextEmailAddress;->emailAddress:Ljava/lang/String;

    .line 30421
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30425
    const v0, 0x262a2f7

    return v0
.end method
