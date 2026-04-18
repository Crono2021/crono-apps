.class public Lorg/drinkless/tdlib/TdApi$SetDatabaseEncryptionKey;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetDatabaseEncryptionKey"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x47ccba4b


# instance fields
.field public newEncryptionKey:[B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19609
    return-void
.end method

.method public constructor <init>([B)V
    .locals 0
    .param p1, "bArr"    # [B

    .line 19599
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19600
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetDatabaseEncryptionKey;->newEncryptionKey:[B

    .line 19601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19605
    const v0, -0x47ccba4b

    return v0
.end method
