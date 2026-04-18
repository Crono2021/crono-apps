.class public Lorg/drinkless/tdlib/TdApi$ChangeImportedContacts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChangeImportedContacts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ImportedContacts;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x42bc228f


# instance fields
.field public contacts:[Lorg/drinkless/tdlib/TdApi$ImportedContact;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9564
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 9565
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ImportedContact;)V
    .locals 0
    .param p1, "importedContactArr"    # [Lorg/drinkless/tdlib/TdApi$ImportedContact;

    .line 9555
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 9556
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChangeImportedContacts;->contacts:[Lorg/drinkless/tdlib/TdApi$ImportedContact;

    .line 9557
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9561
    const v0, 0x42bc228f

    return v0
.end method
