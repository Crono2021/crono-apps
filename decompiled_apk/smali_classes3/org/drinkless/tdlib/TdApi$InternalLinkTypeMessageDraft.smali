.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMessageDraft;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeMessageDraft"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x276fbad5


# instance fields
.field public containsLink:Z

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27725
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "z8"    # Z

    .line 27714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27715
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMessageDraft;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 27716
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeMessageDraft;->containsLink:Z

    .line 27717
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27721
    const v0, 0x276fbad5

    return v0
.end method
