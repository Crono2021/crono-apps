.class public Lorg/drinkless/tdlib/TdApi$SuggestedActionCustom;
.super Lorg/drinkless/tdlib/TdApi$SuggestedAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuggestedActionCustom"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7cbec343


# instance fields
.field public description:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public name:Ljava/lang/String;

.field public title:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45750
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedAction;-><init>()V

    .line 45751
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p3, "formattedText2"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p4, "str2"    # Ljava/lang/String;

    .line 45738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedAction;-><init>()V

    .line 45739
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SuggestedActionCustom;->name:Ljava/lang/String;

    .line 45740
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SuggestedActionCustom;->title:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 45741
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SuggestedActionCustom;->description:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 45742
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SuggestedActionCustom;->url:Ljava/lang/String;

    .line 45743
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45747
    const v0, 0x7cbec343

    return v0
.end method
