.class public Lorg/drinkless/tdlib/TdApi$SearchPublicMessagesByTag;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchPublicMessagesByTag"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x25976caa


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public tag:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39866
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39867
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "i9"    # I

    .line 39855
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39856
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicMessagesByTag;->tag:Ljava/lang/String;

    .line 39857
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicMessagesByTag;->offset:Ljava/lang/String;

    .line 39858
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicMessagesByTag;->limit:I

    .line 39859
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39863
    const v0, 0x25976caa

    return v0
.end method
