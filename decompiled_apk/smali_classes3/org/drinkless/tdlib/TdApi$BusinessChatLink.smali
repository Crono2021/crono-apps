.class public Lorg/drinkless/tdlib/TdApi$BusinessChatLink;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessChatLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7166747d


# instance fields
.field public link:Ljava/lang/String;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public title:Ljava/lang/String;

.field public viewCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42606
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42607
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "i9"    # I

    .line 42594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42595
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessChatLink;->link:Ljava/lang/String;

    .line 42596
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessChatLink;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 42597
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessChatLink;->title:Ljava/lang/String;

    .line 42598
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$BusinessChatLink;->viewCount:I

    .line 42599
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42603
    const v0, -0x7166747d

    return v0
.end method
