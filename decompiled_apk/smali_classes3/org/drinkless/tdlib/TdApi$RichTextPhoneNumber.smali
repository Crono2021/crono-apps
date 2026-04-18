.class public Lorg/drinkless/tdlib/TdApi$RichTextPhoneNumber;
.super Lorg/drinkless/tdlib/TdApi$RichText;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RichTextPhoneNumber"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7a91543


# instance fields
.field public phoneNumber:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$RichText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 30449
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RichText;Ljava/lang/String;)V
    .locals 0
    .param p1, "richText"    # Lorg/drinkless/tdlib/TdApi$RichText;
    .param p2, "str"    # Ljava/lang/String;

    .line 30438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$RichText;-><init>()V

    .line 30439
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RichTextPhoneNumber;->text:Lorg/drinkless/tdlib/TdApi$RichText;

    .line 30440
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RichTextPhoneNumber;->phoneNumber:Ljava/lang/String;

    .line 30441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30445
    const v0, 0x7a91543

    return v0
.end method
