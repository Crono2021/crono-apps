.class public Lorg/drinkless/tdlib/TdApi$AddContact;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddContact"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7d16869c


# instance fields
.field public contact:Lorg/drinkless/tdlib/TdApi$ImportedContact;

.field public sharePhoneNumber:Z

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35376
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35377
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ImportedContact;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "importedContact"    # Lorg/drinkless/tdlib/TdApi$ImportedContact;
    .param p4, "z8"    # Z

    .line 35365
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35366
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddContact;->userId:J

    .line 35367
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AddContact;->contact:Lorg/drinkless/tdlib/TdApi$ImportedContact;

    .line 35368
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$AddContact;->sharePhoneNumber:Z

    .line 35369
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35373
    const v0, -0x7d16869c

    return v0
.end method
