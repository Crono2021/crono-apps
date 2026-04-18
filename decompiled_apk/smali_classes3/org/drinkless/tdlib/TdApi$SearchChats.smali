.class public Lorg/drinkless/tdlib/TdApi$SearchChats;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchChats"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chats;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x700b4634


# instance fields
.field public limit:I

.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30549
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 30538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30539
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchChats;->query:Ljava/lang/String;

    .line 30540
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SearchChats;->limit:I

    .line 30541
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30545
    const v0, -0x700b4634

    return v0
.end method
