.class public Lorg/drinkless/tdlib/TdApi$SearchOutgoingDocumentMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchOutgoingDocumentMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3fdc3b82


# instance fields
.field public limit:I

.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30648
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30649
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 30638
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30639
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchOutgoingDocumentMessages;->query:Ljava/lang/String;

    .line 30640
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SearchOutgoingDocumentMessages;->limit:I

    .line 30641
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30645
    const v0, -0x3fdc3b82

    return v0
.end method
