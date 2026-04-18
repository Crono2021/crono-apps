.class public Lorg/drinkless/tdlib/TdApi$PreparedInlineMessageId;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PreparedInlineMessageId"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x380d9be4


# instance fields
.field public expirationDate:I

.field public id:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29388
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29389
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 29378
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29379
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PreparedInlineMessageId;->id:Ljava/lang/String;

    .line 29380
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PreparedInlineMessageId;->expirationDate:I

    .line 29381
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29385
    const v0, 0x380d9be4

    return v0
.end method
